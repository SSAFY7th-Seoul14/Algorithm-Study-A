package BOJ0220;

import java.util.Scanner;

public class BOJ_17136 {
    static int[][] board;
    static int[] count = {5, 5, 5, 5, 5};
    static int answer, cnt;

    static boolean check(int[][] board, int x, int y, int k) {
        for (int i = x; i < x + k + 1; i++) {
            for (int j = y; j < y + k + 1; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void cover(int x, int y, int k) {
        for (int i = x; i < x + k + 1; i++) {
            for (int j = y; j < y + k + 1; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void restore(int x, int y, int k) {
        for (int i = x; i < x + k + 1; i++) {
            for (int j = y; j < y + k + 1; j++) {
                board[i][j] = 1;
            }
        }
    }

    static void sol(int x, int y, int used) {
        System.out.println(x+" "+y);

        if (used >= answer) return;
        if (cnt == 0) {
            answer = Math.min(answer, used);
            return;
        }
        if (board[x][y] == 1) {
            for (int k = 4; k > -1; k--) {
                if (x + k <= 9 && y + k <= 9 && check(board, x, y, k) && count[k] > 0) {
                    cover(x, y, k);
                    count[k] -= 1;
                    cnt -= ((k + 1) * (k + 1));
                    if (y + k == 9) sol(x + 1, 0, used + 1);
                    else sol(x, y+k+1, used + 1);
                    cnt += ((k + 1) * (k + 1));
                    count[k] += 1;
                    restore(x, y, k);
                }
            }
        }
        else{
            if(y==9) sol(x+1,0,used);
            else sol(x,y+1,used);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[10][10];
        answer = Integer.MAX_VALUE;
        cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int a = sc.nextInt();
                if (a == 1) cnt += 1;
                board[i][j] = a;
            }
        }
        sol(0, 0, 0);
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }
}
