package BOJ0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
    static char[][] board;
    static void sol(int x, int y, int n){
        if(n==1) return;
        for(int i=x;i<x+n;i+=n/3){
            for(int j=y;j<y+n;j+=n/3){
                if(i==x+n/3&&j==y+n/3){
                    for(int k=i;k<i+n/3;k++){
                        for(int l=j;l<j+n/3;l++){
                            board[k][l]=' ';
                        }
                    }
                }
                else sol(i,j,n/3);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='*';
            }
        }
        sol(0,0,n);
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n;j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        for(int j=0;j<n;j++) sb.append(board[n-1][j]);
        System.out.println(sb);
    }
}
