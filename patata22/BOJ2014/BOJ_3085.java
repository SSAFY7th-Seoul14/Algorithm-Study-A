package BOJ2014;

import java.util.Scanner;

public class BOJ_3085 {
    static String[][] board;
    static int n, answer = 0;

    static void swap(int x1, int y1, int x2, int y2) {
        String temp = board[x2][y2];
        board[x2][y2] = board[x1][y1];
        board[x1][y1] = temp;
    }

    static void count_h() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j].equals(board[i][j + 1])){
                    temp += 1;
                    max = Math.max(temp, max);
                }
                else temp = 1;
            }
        }
        answer = Math.max(answer, max);
    }

    static int count_v() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i].equals(board[j + 1][i])) {
                    temp += 1;
                    max = Math.max(temp, max);
                } else temp = 1;

            }
        }
        answer = Math.max(answer, max);
        return max;
    }

    static void sol() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!board[i][j].equals(board[i][j + 1])) {
                    swap(i, j, i, j + 1);
                    count_h();
                    count_v();
                    swap(i, j, i, j + 1);
                }
                if (!board[j][i].equals(board[j + 1][i])) {
                    swap(j, i, j + 1, i);
                    count_h();
                    count_v();
                    swap(j, i, j + 1, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        board = new String[n][n];
        for (int i = 0; i < n; i++) board[i] = sc.nextLine().split("");
        sol();
        System.out.println(answer);

    }
}
