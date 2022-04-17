package jhkim.p220405;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int buses = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] costs = new int[n][n];
        final int maxi = 999999999;

        int from, to, cost;

        for (int i = 0; i < buses; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            cost = Integer.parseInt(st.nextToken());
            if (map[from][to] != 0) {
                map[from][to] = Math.min(map[from][to], cost);
            } else {
                map[from][to] = cost;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = maxi;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;
                for (int j = 0; j < n; j++) {
                    if (j == k || i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 999999999) map[i][j] = 0;
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
