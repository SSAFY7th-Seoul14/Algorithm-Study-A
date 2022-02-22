package BOJ0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1018 {
    static char[][] board;
    static int answer=Integer.MAX_VALUE;
    static int check_w(int x,int y){
        char now = 'W';
        int temp=0;
        for(int i=x;i<x+8;i+=2){
            for(int j=y;j<y+8;j+=2){
                if(board[i][j]!=now) temp+=1;
            }
            for(int j=y+1;j<y+8;j+=2){
                if(board[i][j]==now) temp+=1;
            }
        }
        for(int i=x+1;i<x+8;i+=2){
            for(int j=y;j<y+8;j+=2){
                if(board[i][j]==now) temp+=1;
            }
            for(int j=y+1;j<y+8;j+=2){
                if(board[i][j]!=now) temp+=1;
            }
        }
        return temp;
    }
    static int check_b(int x,int y){
        char now = 'B';
        int temp=0;
        for(int i=x;i<x+8;i+=2){
            for(int j=y;j<y+8;j+=2){
                if(board[i][j]!=now) temp+=1;
            }
            for(int j=y+1;j<y+8;j+=2){
                if(board[i][j]==now) temp+=1;
            }
        }
        for(int i=x+1;i<x+8;i+=2){
            for(int j=y;j<y+8;j+=2){
                if(board[i][j]==now) temp+=1;
            }
            for(int j=y+1;j<y+8;j+=2){
                if(board[i][j]!=now) temp+=1;
            }
        }
        return temp;
    }

    static void sol(int x, int y){
        answer = Math.min(answer,Math.min(check_w(x,y),check_b(x,y)));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n= Integer.parseInt(s[0]), m= Integer.parseInt(s[1]);
        board = new char[n][];
        for(int i=0;i<n;i++) board [i] = br.readLine().toCharArray();
        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                sol(i,j);
            }
        }
        System.out.println(answer);


    }
}
