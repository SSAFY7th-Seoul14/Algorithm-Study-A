package jhkim.p220403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

    static int M, N, H, tomaten[][][], nx, ny, nz, result;
    static boolean[][][] visited;
    static Queue<Tomate> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Tomate {
        int x, y, z;

        public Tomate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomaten = new int[N][M][H];
        visited = new boolean[N][M][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomaten[j][k][i] = Integer.parseInt(st.nextToken());
                    if (tomaten[j][k][i] == 1) {
                        q.offer(new Tomate(j, k, i));
                    }
                }
            }
        }

        reifen();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomaten[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void reifen() {

        Tomate cur;
        int level = 0;

        while (!q.isEmpty()) {
            visited[q.peek().x][q.peek().y][q.peek().z] = true;
            int size = q.size();

            while (--size >= 0) {
                cur = q.poll();

                for (int i = 0; i < 6; i++) {
                    nx = cur.x + dx[i];
                    ny = cur.y + dy[i];
                    nz = cur.z + dz[i];

                    if (!isIn(nx, ny, nz)) continue;

                    q.offer(new Tomate(nx, ny, nz));
                    visited[nx][ny][nz] = true;
                    tomaten[nx][ny][nz] = 1;
                }
            }
            result = level++;
        }
    }

    private static boolean isIn(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= N || y >= M || z >= H) return false;
        if (visited[x][y][z]) return false;
        if (tomaten[x][y][z] != 0) return false;
        return true;
    }
}
