package jhkim.p220331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149 {

    static int N, cost[][], pick, temp;
    static int houses[][];

    public static int color() {

        int res;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                temp = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    } else if (temp > houses[i - 1][k]) {
                        temp = houses[i - 1][k];
                    }
                }
                houses[i][j] = temp + cost[i - 1][j];
            }
        }

        res = Math.min(houses[N][0], Math.min(houses[N][1], houses[N][2]));

        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        houses = new int[N + 1][3];

        System.out.println(color());
    }
}
