package BOJ0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {
    static int[] dx={0,1,0,-1}, dy={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int x=0,y=0,min_x=0,min_y=0,max_x=0,max_y=0,i=0;
            char[] command = br.readLine().toCharArray();
            for(char c:command){
                if(c=='F') {
                    x += dx[i];y += dy[i];
                }
                else if(c=='B'){
                    x-=dx[i];y-=dy[i];}
                else if(c=='R') i=(i+1)%4;
                else if(c=='L') i=(i+3)%4;
                min_x=Math.min(min_x,x); min_y=Math.min(min_y,y);
                max_x=Math.max(max_x,x); max_y=Math.max(max_y,y);
            }
            System.out.println((max_x-min_x)*(max_y-min_y));
        }

    }
}
