package jhkim.p220401;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

    static class Vertex implements Comparable<Vertex>{
        int x, y, val;

        public Vertex(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = 0;
        int N, map[][];
        while (true) {
            tc++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            PriorityQueue<Vertex> pq = new PriorityQueue<>();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pq.offer(new Vertex(0, 0, map[0][0]));
            int[][] distance = new int[N][N];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int nx, ny;

            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[0][0] = map[0][0];
            int currentX = 0, currentY = 0, changeX = 0, changeY = 0;

            while (!pq.isEmpty()) {
                currentX = pq.peek().x;
                currentY = pq.poll().y;
                for (int j = 0; j < 4; j++) {
                    nx = currentX + dx[j];
                    ny = currentY + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (distance[nx][ny] > distance[currentX][currentY] + map[nx][ny]) {
                        distance[nx][ny] = distance[currentX][currentY] + map[nx][ny];
                        pq.offer(new Vertex(nx, ny, distance[nx][ny]));
                    }
                }
                if (currentX == N - 1 && currentY == N - 1) break;
            }

            bw.write("Problem " + tc + ": " + distance[N - 1][N - 1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
