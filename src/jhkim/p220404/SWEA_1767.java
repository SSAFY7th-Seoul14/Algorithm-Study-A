package jhkim.p220404;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767 {
    static int N, processor[][], result, coreCount, nx, ny;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Core> cores;

    static class Core {
        int x, y;

        public Core(int x, int y) {
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

            N = Integer.parseInt(br.readLine());
            processor = new int[N][N];
            result = 0;
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    processor[i][j] = Integer.parseInt(st.nextToken());
                    if (processor[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
                        cores.add(new Core(i, j));
                    }
                }
            }

            result = Integer.MAX_VALUE;
            coreCount = 0;

            dfs(0, 0, 0);
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int idx, int count, int minLength) {

        if (idx == cores.size()) {
            if (coreCount < count) {
                coreCount = count;
                result = minLength;
            } else if (coreCount == count) {
                result = Math.min(result, minLength);
            }
            return;
        }

        int x = cores.get(idx).x;
        int y = cores.get(idx).y;

        for (int i = 0; i < 4; i++) {
            int cnt = 0, nx = x, ny = y;

            while (true) {
                nx += dx[i];
                ny += dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                if (processor[nx][ny] == 1) {
                    cnt = 0;
                    break;
                }
                cnt++;
            }

            nx = x;
            ny = y;

            for (int j = 0; j < cnt; j++) {
                nx += dx[i];
                ny += dy[i];
                processor[nx][ny] = 1;
            }

            if (cnt == 0) {
                dfs(idx + 1, count, minLength + cnt);
            } else {
                dfs(idx + 1, count + 1, minLength + cnt);
            }

            nx = x;
            ny = y;

            for (int j = 0; j < cnt; j++) {
                nx += dx[i];
                ny += dy[i];
                processor[nx][ny] = 0;
            }
        }
    }
}
