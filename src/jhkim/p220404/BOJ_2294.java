package jhkim.p220404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    static int n, k, coins[];
    static int[] dp = new int[10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            dp[coins[i]] = 1;
        }
        Arrays.sort(coins);

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < n; j++) {
                if(i < coins[j] || (i - coins[j]) < coins[0]) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        if(dp[k] > k) dp[k] = -1;
        System.out.println(dp[k]);
    }
}
