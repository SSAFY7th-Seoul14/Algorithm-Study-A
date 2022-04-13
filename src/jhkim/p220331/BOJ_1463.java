package jhkim.p220331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        dp = new int[X + 1];

        System.out.println(makeOne(X));
    }

    public static int makeOne(int n) {
        dp[0] = 0;
        dp[1] = 0;

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                if (i % 3 == 0 && i % 2 == 0) {
                    dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
                } else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        return dp[n];
    }
}
