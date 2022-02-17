package BOJ0215;

import java.util.Scanner;

public class BOJ_4796 { //S5
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=0;
        while(true) {
            t+=1;
            int p = sc.nextInt(), l = sc.nextInt(), v = sc.nextInt(), answer = 0;
            if(p==0&&l==0&&v==0) break;
            answer+=(v/l)*p;
            answer+=Math.min(v%l,p);
            System.out.printf("Case %d: %d%n", t, answer);
        }
    }
}
