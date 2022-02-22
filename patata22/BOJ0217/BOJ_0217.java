package BOJ0217;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_0217 {
    static String x;
    static int n;
    static boolean finish=false;
    static boolean[] used;
    static boolean check(String s){
        boolean c = true;
        String[] temp = s.trim().split(" ");
        int len = temp.length;
        int[] number = new int[len];
        for(int i=0;i<len;i++) number[i]=Integer.parseInt(temp[i]);
        Arrays.sort(number);
        for(int i=0;i<len;i++){
            if(number[i]!=i+1){
                c=false;
                break;
            }
        }
        if(c==true){
            for(String x:temp){
                System.out.print(x+" ");
            }
        }
        return c;
    }

    static void sol(int start, String record){
        if(finish) return;
        if(start==n) {
            if(check(record)){
                finish=true;
            }
            return;
        }
        if(x.charAt(start)=='0') return;
        for(int i=start;i<Math.min(x.length(),start+2);i++){
            int temp = Integer.parseInt(x.substring(start,i+1));
            if(temp>50||used[temp]) continue;
            used[temp]=true;
            sol(i+1, record+" "+x.substring(start,i+1));
            used[temp]=false;

        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        x = sc.nextLine();
        n = x.length();
        used= new boolean[51];
        sol(0,"");

    }
}
