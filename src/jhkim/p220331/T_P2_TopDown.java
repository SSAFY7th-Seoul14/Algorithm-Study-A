package jhkim.p220331;

public class T_P2_TopDown {

    static int[] dp;

    public static int stick(int n) {
        if(n == 1) return 2;
        if(n == 2) return 5;
        else if(dp[n] != 0) return dp[n];
        else return dp[n] = 2 * stick(n -1) + stick(n - 2);
    }

    public static void main(String[] args) {
        //n = 6이라고 가정, 입력받으면 됨

        dp = new int[7];
        System.out.println(stick(6));
    }

}
