package BOJ0213;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1244 {
    static int n;
    static String[] bulb;

    static void switch_m(int x){
        for(int i=x;i<=n;i+=x){
            if(bulb[i].equals("0")) bulb[i]="1";
            else bulb[i]="0";
        }
    }
    static void switch_w(int x){
        int l=x, r= x;
        while(l>1&&r<n&&(bulb[l-1].equals(bulb[r+1]))){
            l-=1;
            r+=1;

        }
        for(int i=l;i<=r;i++){
            if(bulb[i].equals("0")) bulb[i]="1";
            else bulb[i]="0";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=Integer.parseInt(sc.nextLine());
        bulb=("0 "+sc.nextLine()).split(" ");
        int m = Integer.parseInt(sc.nextLine());
        for(int i=0;i<m;i++){
            String[] temp = sc.nextLine().split(" ");
            if(Integer.parseInt(temp[0])==1) switch_m(Integer.parseInt(temp[1]));
            else switch_w(Integer.parseInt(temp[1]));
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            cnt+=1;
            System.out.print(bulb[i]+" ");
            if(cnt==20){
                System.out.println();
                cnt=0;
            }
        }
    }
}
