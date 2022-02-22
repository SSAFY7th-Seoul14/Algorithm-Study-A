package BOJ0220;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1182 {
    static int n, s,answer;
    static int[] number;
    static void sol(int start, int sum){
        for(int i=start;i<n;i++){
            if(sum+number[i]==s) answer+=1;
            sol(i+1,sum+number[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();s=sc.nextInt();
        answer=0;
        number = new int[n];
        for(int i=0;i<n;i++) number[i] = sc.nextInt();
        sol(0,0);
        System.out.println( answer);
    }
}
