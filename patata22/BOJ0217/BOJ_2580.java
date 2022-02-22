package BOJ0217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2580 {
    static ArrayList<int[]> zero = new ArrayList();
    static int[][] board;
    static boolean finish = false;
    static int count = 0;

    static LinkedList able(int x, int y) {
        LinkedList<Integer> number = new LinkedList();
        for (int i = 1; i < 10; i++) number.add(i);
        for (int i = 0; i < 9; i++) {
            if (number.contains(board[x][i])) number.remove((Object)board[x][i]);
            if (number.contains(board[i][y])) number.remove((Object)board[i][y]);
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (number.contains(board[i][j])) number.remove((Object)board[i][j]);
            }
        }
        return number;
    }

    static void sol(int n) {
        if (finish) return;
        if (n == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) System.out.print(board[i][j] + " ");
                System.out.println();
            }
            finish = true;
            return;
        }
        int i = zero.get(n)[0];
        int j = zero.get(n)[1];
        for (Object k : able(i, j)) {
            board[i][j] = (int) k;
            sol(n + 1);
            if (finish) return;
            board[i][j] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int a = sc.nextInt();
                if (a == 0) {
                    count += 1;
                    zero.add(new int[]{i, j});
                }
                board[i][j] = a;
            }
        }
        sol(0);
    }
}
