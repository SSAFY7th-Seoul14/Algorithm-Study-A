package jhkim.p220407;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249 {

    static int N, map[][], result, dp[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String str;

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dp = new int[N][N];
            visited = new boolean[N][N];
            result = Integer.MAX_VALUE;

            for(int i = 0; i < N; i++) {
                str = br.readLine();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for(int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            visited[0][0] = true;
            dp[0][0] = 0;
            bfs();

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        Point cur;
        q.offer(new Point(0, 0));
        while(!q.isEmpty()) {
            cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if(x == N -1 && y == N - 1) {
                result = Math.min(result, dp[x][y]);
            }
            if(result <= dp[x][y]) continue;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(!visited[nx][ny] || dp[nx][ny] > dp[x][y] + map[nx][ny]) {
                    dp[nx][ny] = dp[x][y] + map[nx][ny];
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}
