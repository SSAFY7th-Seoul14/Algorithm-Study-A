package BOJ0220;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15683 {
    static ArrayList<Camera> Cameras = new ArrayList<>();
    static int n, m, answer,cnt_zero;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean flag = false;

    static int[][] copy(int[][] board) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(board[i], 0, temp[i], 0, m);
        }
        return temp;
    }
    static void go(int x, int y , int i,int[][] board){
        while(true){
            x+=dx[i];
            y+=dy[i];
            if(x<0||x>=n||y<0||y>=m||board[x][y]==6) return;
        }
    }

    static void sol(int cnt, int[][] board, int cnt_one) {
        if (flag) return;
        if (cnt == Cameras.size()) {
            answer=Math.min(answer,cnt_zero-cnt_one);
            if (answer == 0) flag = true;
            return;
        }
        Camera now = Cameras.get(cnt);
        int[][] temp;
        if (now.type == 1) {
            for (int k = 0; k < 4; k++) {
                temp = copy(board);
                int temp_one = 0;
                int nx = now.x, ny = now.y;
                while (0 <= nx + dx[k] && nx + dx[k] < n && 0 <= ny + dy[k] && ny + dy[k] < m && board[nx + dx[k]][ny + dy[k]] != 6) {
                    nx += dx[k];
                    ny += dy[k];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;
                    sol(cnt + 1, temp,cnt_one+temp_one);
                }
            }

        } else if (now.type == 2) {
            for (int i = 0; i < 2; i++) {
                temp = copy(board);
                int temp_one=0;
                int nx = now.x;
                int ny = now.y;
                while (0 <= nx + dx[i] && nx + dx[i] < n && 0 <= ny + dy[i] && ny + dy[i] < m && board[nx + dx[i]][ny + dy[i]] != 6) {
                    nx += dx[i];
                    ny += dy[i];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;
                }
                int j=i+2;
                nx = now.x;
                ny = now.y;
                while (0 <= nx + dx[j] && nx + dx[j] < n && 0 <= ny + dy[j] && ny + dy[j] < m && board[nx + dx[j]][ny + dy[j]] != 6) {
                    nx += dx[j];
                    ny += dy[j];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;
                }
                sol(cnt + 1, temp,cnt_one+temp_one);
            }
        } else if (now.type == 3) {
            for (int i = 0; i < 4; i++) {
                temp = copy(board);
                int temp_one=0;
                int nx = now.x;
                int ny = now.y;
                while (0 <= nx + dx[i] && nx + dx[i] < n && 0 <= ny + dy[i] && ny + dy[i] < m && board[nx + dx[i]][ny + dy[i]] != 6) {
                    nx += dx[i];
                    ny += dy[i];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;
                }
                nx=now.x;
                ny=now.y;
                int j = (i + 1) % 4;
                while (0 <= nx + dx[j] && nx + dx[j] < n && 0 <= ny + dy[j] && ny + dy[j] < m && board[nx + dx[j]][ny + dy[j]] != 6) {
                    nx += dx[j];
                    ny += dy[j];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;
                }
                sol(cnt + 1, temp,cnt_one+temp_one);
            }
        } else if (now.type == 4) {
            for (int i = 0; i < 4; i++) {
                temp = copy(board);
                int temp_one=0;
                for (int j = 0; j < 4; j++) {
                    if (i != j) {
                        int nx = now.x, ny = now.y;
                        while (0 <= nx + dx[j] && nx + dx[j] < n && 0 <= ny + dy[j] && ny + dy[j] < m && board[nx + dx[j]][ny + dy[j]] != 6) {
                            nx += dx[j];
                            ny += dy[j];
                            if(board[nx][ny]==0) temp_one+=1;
                            temp[nx][ny] = 7;
                        }
                    }
                }
                sol(cnt + 1, temp,cnt_one+temp_one);
            }
        } else if (now.type == 5) {
            temp = copy(board);
            int temp_one=0;
            for (int i = 0; i < 4; i++) {
                int nx = now.x, ny = now.y;
                while (0 <= nx + dx[i] && nx + dx[i] < n && 0 <= ny + dy[i] && ny + dy[i] < m && board[nx + dx[i]][ny + dy[i]] != 6) {
                    nx += dx[i];
                    ny += dy[i];
                    if(board[nx][ny]==0) temp_one+=1;
                    temp[nx][ny] = 7;

                }
            }
            sol(cnt + 1, temp,cnt_one+temp_one);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cnt_zero=0;
        answer = Integer.MAX_VALUE;
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                if(a==0) cnt_zero+=1;
                if(a!=0&&a!=6) {
                    Cameras.add(new Camera(i, j, a));
                }
                board[i][j] = a;
            }
        }
        sol(0, board,0);
        System.out.println(answer);
    }
}

class Camera {
    int x, y, type;

    public Camera(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}