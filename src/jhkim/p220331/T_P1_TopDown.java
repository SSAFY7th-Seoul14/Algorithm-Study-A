package jhkim.p220331;

public class T_P1_TopDown {

    static int[] dp;

    public static int color(int n) {
        if(n == 1) return 2;
        if(n == 2) return 3;

        if(dp[n] != 0) return dp[n];
        else {
            return dp[n] = color(n - 1) + color(n - 2);
        }

    }

    public static void main(String[] args) {
        //n을 8이라고 가정한 경우(n 입력받으면 됨)

        dp = new int[9];
        System.out.println(color(8));
    }
}
