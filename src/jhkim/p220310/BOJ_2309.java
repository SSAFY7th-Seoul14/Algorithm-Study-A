package jhkim.p220310;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
    static int[] dwarfs = new int[9];
    static int[] res = new int[7];
    static boolean finded = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }

        Arrays.sort(dwarfs);

        find(0, 0, 0);

    }

    static void find(int start, int count, int sum) {
        if (!finded) {
            if (count == 7) {
                if (sum == 100) {
                    for (int i = 0; i < 7; i++) {
                        System.out.println(res[i]);
                    }
                    finded = true;
                }
                return;
            }

            for (int i = start; i < 9; i++) {
                res[count] = dwarfs[i];
                find(i + 1, count + 1, sum + dwarfs[i]);
            }
        }
    }
}
