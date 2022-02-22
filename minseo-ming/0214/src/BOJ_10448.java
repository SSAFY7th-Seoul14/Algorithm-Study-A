import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_10448 {

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        boolean eq ;

        while (t-- > 0) {
            int num = sc.nextInt();
            eq = false;
            outer:
            for (int i = 1; i <= 44; i++) {
                for (int j = 1; j <= 44; j++) {
                    for (int k = 1; k <= 44; k++) {
                        int sum = (i * (i + 1) / 2) + (j * (j + 1) / 2) + (k * (k + 1) / 2);
                        if (sum == num) {
                            eq = true;
                            break outer;
                        }
                    }
                }
            }
            if (eq) System.out.println(1);
            else System.out.println(0);
        }
    }

}
