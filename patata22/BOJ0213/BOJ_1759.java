package BOJ0213;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {
    static int n, k;
    static String vowel = "aeiou";
    static String[] answer, chr;
    static boolean[] used;

    static void sol(int start, int count, int v, int c) {
        if (count == n && v > 0 && c > 1) {
            for (String x : answer) System.out.print(x);
            System.out.println();
        }
        if(count==n) return;
        for (int i = start; i < k; i++) {
            answer[count] = chr[i];
            if (vowel.contains(chr[i])) v += 1;
            else c += 1;
            sol(i + 1, count + 1, v, c);
            if (vowel.contains(chr[i])) v -= 1;
            else c -= 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        chr = sc.nextLine().split(" ");
        answer = new String[n];
        used = new boolean[k];
        Arrays.sort(chr);
        sol(0, 0, 0, 0);
    }
}
