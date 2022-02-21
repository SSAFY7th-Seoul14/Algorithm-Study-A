package BOJ0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
    static int n;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static char[][] board;
    static boolean visited[][];

    static int bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        int cnt=1;
        visited[a][b]=true;
        while(!q.isEmpty()){
            int [] temp = q.poll();
            int x= temp[0], y = temp[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i], ny=y+dy[i];
                if(0<=nx&&nx<n&&0<=ny&&ny<n&&board[nx][ny]=='1'&&!visited[nx][ny]){
                    cnt+=1;
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }

            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        board= new char[n][];
        visited = new boolean[n][n];
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt=0;
        for(int i=0;i<n;i++) board[i] = br.readLine().toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='1'&&!visited[i][j]){
                    cnt+=1;
                    answer.add(bfs(i,j));
                }
            }
        }
        answer.sort((o1, o2) -> o1-o2);
        System.out.println(cnt);
        for(int x:answer) System.out.println(x);

    }
}
