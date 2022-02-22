package BOJ0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759 {
    static String mo = "aeiou";
    static int l,r;
    static String[] letter;
    static void sol(int x1,int x2, int start, int count,String answer){ //모음 수, 자음 수
        if(count==l){
            if(x1>0&&x2>1) System.out.println(answer);
            return;
        }
        for(int i=start;i<r;i++){
            if(mo.contains(letter[i])) sol(x1+1,x2,i+1,count+1,answer+letter[i]);
            else sol(x1,x2+1,i+1,count+1,answer+letter[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        l = Integer.parseInt(temp[0]);
        r = Integer.parseInt(temp[1]);
        letter = br.readLine().split(" ");
        Arrays.sort(letter);
        sol(0,0,0,0,"");

    }
}
