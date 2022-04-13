package jhkim.p220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

    static int K, W, H, result;
    static int map[][], nx, ny, newKmove;
    static boolean visited[][][];
    static int[] knightX = {-1, -2, 2, 1, 1, 2, -2, -1, -1, 0, 1, 0};
    static int[] knightY = {-2, -1, -1, -2, 2, 1, 1, 2, 0, -1, 0, 1};
    static Queue<Monkey> q = new LinkedList<>();
    static Monkey cur;

    static class Monkey {
        int x, y, kmove;

        public Monkey(int x, int y, int kmove) {
            this.x = x;
            this.y = y;
            this.kmove = kmove;
        }

        @Override
        public String toString() {
            return "Monkey{" +
                    "x=" + x +
                    ", y=" + y +
                    ", kmove=" + kmove +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0][0] = true;
        result = Integer.MAX_VALUE;
        bfs();
        if(result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    public static void bfs() {
        q.offer(new Monkey(0, 0, 0));

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            while (--size >= 0) {
                cur = q.poll();

                if (cur.x == H - 1 && cur.y == W - 1) {
                    result = level;
                    return;
                }

                if (cur.kmove < K) {
                    for (int i = 0; i < 12; i++) {
                        nx = cur.x + knightX[i];
                        ny = cur.y + knightY[i];

                        if(i >= 8) newKmove = cur.kmove;
                        else newKmove = cur.kmove + 1;

                        if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1) continue;
                        if(visited[nx][ny][newKmove]) continue;
                        visited[nx][ny][newKmove] = true;

                        q.offer(new Monkey(nx, ny, newKmove));
                    }
                } else {
                    for (int i = 8; i < 12; i++) {
                        nx = cur.x + knightX[i];
                        ny = cur.y + knightY[i];

                        if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1 || visited[nx][ny][cur.kmove]) continue;
                        visited[nx][ny][cur.kmove] = true;

                        q.offer(new Monkey(nx, ny, cur.kmove));
                    }
                }
            }
            level++;
        }
    }
}