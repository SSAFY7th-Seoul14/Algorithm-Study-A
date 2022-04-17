package jhkim.p220413;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

    static int n;
    static Point home, rock, con[];
    static boolean[] visited;
    static boolean result;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];

            result = false;

            st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            con = new Point[n + 1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                con[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }


            st = new StringTokenizer(br.readLine());
            rock = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            con[n] = rock;

            result = bfs();

            if (result) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(home);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i <= n; i++) {

                if (cur.x == rock.x && cur.y == rock.y) {
                    return true;
                }
                if (visited[i]) continue;

                int far = Math.abs(cur.x - con[i].x) + Math.abs(cur.y - con[i].y);

                if (far <= 1000) {
                    q.offer(con[i]);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
