package jhkim.p220413;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013 {

    static int K, magnets[][], result, magnet, dir;

    static class Rotation {
        int idx, dir;

        public Rotation(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            K = Integer.parseInt(br.readLine());
            magnets = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                magnet = Integer.parseInt(st.nextToken()) - 1;
                dir = Integer.parseInt(st.nextToken());
                rotate(magnet, dir);
            }

            result = calculate();

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void rotate(int magnet, int dir) {
        Queue<Rotation> q = new LinkedList<>();

        q.offer(new Rotation(magnet, dir));

        int n = magnet;

        if (dir == 1) {
            while (true) {
                if (n >= 3) break;
                if (magnets[n][2] != magnets[++n][6]) {
                    if (Math.abs(n - magnet) == 2) {
                        q.offer(new Rotation(n, 1));
                    } else {
                        q.offer(new Rotation(n, -1));
                    }
                } else break;
            }
            n = magnet;
            while (true) {
                if (n < 1) break;
                if (magnets[n][6] != magnets[--n][2]) {
                    if (Math.abs(n - magnet) == 2) {
                        q.offer(new Rotation(n, 1));
                    } else {
                        q.offer(new Rotation(n, -1));
                    }
                } else break;
            }
        } else {
            while (true) {
                if (n >= 3) break;
                if (magnets[n][2] != magnets[++n][6]) {
                    if (Math.abs(n - magnet) == 2) {
                        q.offer(new Rotation(n, -1));
                    } else {
                        q.offer(new Rotation(n, 1));
                    }
                } else break;
            }
            n = magnet;
            while (true) {
                if (n < 1) break;
                if (magnets[n][6] != magnets[--n][2]) {
                    if (Math.abs(n - magnet) == 2) {
                        q.offer(new Rotation(n, -1));
                    } else {
                        q.offer(new Rotation(n, 1));
                    }
                } else break;
            }
        }
        while (!q.isEmpty()) {
            clockwise(q.poll());
        }
    }

    private static void clockwise(Rotation cur) {
        int magnetRow = cur.idx;
        int dir = cur.dir;

        if (dir == -1) {
            int temp = magnets[magnetRow][0];
            for (int i = 0; i < 7; i++) {
                magnets[magnetRow][i] = magnets[magnetRow][i + 1];
            }
            magnets[magnetRow][7] = temp;
        } else {
            int temp = magnets[magnetRow][7];
            for (int i = 7; i >= 1; i--) {
                magnets[magnetRow][i] = magnets[magnetRow][i - 1];
            }
            magnets[magnetRow][0] = temp;
        }
    }

    private static int calculate() {
        int ans = 0;

        for (int i = 0; i < 4; i++) {
            ans += magnets[i][0] * Math.pow(2, i);
        }

        return ans;
    }

}
