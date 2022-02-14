package BOJ0213;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6603 {
    static int[] result,number;
    static boolean[] used;
    static int n;
    static void comb(int m, int k){
        if(m==6){
            for(int x:result) System.out.print(x+" ");
            System.out.println();
            return;
            }
        for(int i=k;i<n;i++){
            if(!used[i]){
                result[m]=number[i];
                used[i]=true;
                comb(m+1,i+1);
                used[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean first= true;
        while(true){
            String[] temp = sc.nextLine().split(" ");
            if(temp[0].equals("0")) break;
            if(first) first=false;
            else System.out.println();
            n= Integer.parseInt(temp[0]);
            result= new int[6];
            used = new boolean[n];
            number= new int[n];
            for(int i=0;i<n;i++) number[i] = Integer.parseInt(temp[i+1]);
            comb(0,0);

        }
    }
}
