package jhkim.p220331;

public class T_P1_BottomUp {

    static int[] dp;

    public static int color(int n) {
        dp[1] = 2;
        dp[2] = 3;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //n을 8이라고 가정한 경우(n 입력받으면 됨)

        dp = new int[9];
        System.out.println(color(8));
    }
}
