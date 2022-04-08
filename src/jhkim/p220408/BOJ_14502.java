package jhkim.p220408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14502 {
    static int N, M, map[][], x, y, nx, ny, result = Integer.MAX_VALUE, empty;
    static ArrayList<Point> empties = new ArrayList<>();
    static ArrayList<Point[]> cases = new ArrayList<>();
    static Point[] now = new Point[3];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Point> viruses = new ArrayList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empties.add(new Point(i, j));
                    empty++;
                }
                if (map[i][j] == 2) {
                    viruses.add(new Point(i, j));
                }
            }
        }
        combi(0, 0);

        for (int i = 0; i < cases.size(); i++) {
            for (int j = 0; j < 3; j++) {
                map[cases.get(i)[j].x][cases.get(i)[j].y] = 1;
            }
            result = Math.min(result, bfs());

            for (int j = 0; j < 3; j++) {
                map[cases.get(i)[j].x][cases.get(i)[j].y] = 0;
            }
        }
        System.out.println(empty - 3 - result + viruses.size());
        br.close();
    }

    private static void combi(int start, int count) {
        if (count == 3) {
            Point[] up = new Point[3];
            for (int i = 0; i < 3; i++) {
                up[i] = now[i];
            }
            cases.add(up);
            return;
        }
        for (int i = start; i < empties.size(); i++) {
            now[count] = empties.get(i);
            combi(i + 1, count + 1);
        }
    }

    private static int bfs() {

        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        Queue<Point> q = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < viruses.size(); i++) {
            q.add(viruses.get(i));
        }
        Point curr;
        while (!q.isEmpty()) {
            curr = q.poll();

            x = curr.x;
            y = curr.y;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || temp[nx][ny] != 0) continue;
                q.offer(new Point(nx, ny));
                temp[nx][ny] = 2;
            }
            result++;
        }
        return result;
    }
}
