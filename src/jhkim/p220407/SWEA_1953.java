package jhkim.p220407;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
    static int N, M, R, C, L, map[][], result, nx, ny;
    static int[] dx = {-1, 1, 0, 0};    //상하좌우
    static int[] dy = {0, 0, -1, 1};    //상하좌우
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
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            result = 1;

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited[R][C] = true;
            bfs();

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static Queue<Point> q;

    private static void bfs() {
        q = new LinkedList<>();
        Point cur;
        q.offer(new Point(R, C));
        int level = 0;

        while (true) {
            if (level == L - 1) {
                return;
            }

            int size = q.size();
            while (--size >= 0) {
                cur = q.poll();

                int x = cur.x;
                int y = cur.y;

                switch (map[x][y]) {
                    case 1:
                        indi(x, y, 0, 4, 1);
                        break;
                    case 2:
                        indi(x, y, 0, 2, 1);
                        break;
                    case 3:
                        indi(x, y, 2, 4, 1);
                        break;
                    case 4:
                        indi(x, y, 0, 4, 3);
                        break;
                    case 5:
                        indi(x, y, 1, 4, 2);
                        break;
                    case 6:
                        indi(x, y, 1, 3, 1);
                        break;
                    case 7:
                        indi(x, y, 0, 3, 2);
                        break;
                }
            }
            level++;
        }
    }

    private static void indi(int x, int y, int start, int to, int step) {
        for (int i = start; i < to; i+=step) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (!isIn(nx, ny)) continue;
            if (map[nx][ny] == 0) continue;
            if (!isLinked(map[x][y], map[nx][ny], i)) continue;
            result++;
            visited[nx][ny] = true;
            q.offer(new Point(nx, ny));
        }
    }

    private static boolean isIn(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return false;
        if (visited[nx][ny]) return false;
        return true;
    }

    private static boolean isLinked(int i, int j, int d) {
        switch (d) {
            case 0:
                if(i == 1 || i == 2 || i == 4 || i == 7) {
                    if(j == 1 || j == 2 || j == 5 || j == 6) return true;
                }
                break;
            case 1:
                if(i == 1 || i == 2 || i == 5 || i == 6) {
                    if (j == 1 || j == 2 || j == 4 || j == 7) return true;
                }
                break;
            case 2:
                if(i == 1 || i == 3 || i == 6 || i == 7) {
                    if(j == 1 || j == 3 || j == 4 || j == 5) return true;
                }
                break;
            case 3:
                if(i == 1 || i == 3 || i == 4 || i == 5) {
                    if(j == 1 || j == 3 || j == 6 || j == 7) return true;
                }
                break;
        }
        return false;
    }
}
