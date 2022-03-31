package jhkim.p220331;

public class T_P2_BottomUp {

    static int[] dp;

    public static int stick(int n) {
        dp[1] = 2;
        dp[2] = 5;

        for(int i = 3; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //n = 6이라고 가정, 입력받으면 됨

        dp = new int[7];
        System.out.println(stick(6));
    }

}
