package jhkim.p220406;

import java.io.*;

public class BOJ_2239 {
    static int[][] sudoku;
    static boolean flag;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];
        String str;

        for (int i = 0; i < 9; i++) {
            str = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
                if (sudoku[i][j] == 0) count++;
            }
        }
        fill(0, 0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(sudoku[i][j] + "");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void fill(int i, int j, int depth) {

        if (depth == count) {
            flag = true;
            return;
        }

        if(i == 9) return;

        if (sudoku[i][j] != 0) {
            if (j + 1 == 9) {
                fill(i + 1, 0, depth);
            } else {
                fill(i, j + 1, depth);
            }
        } else {
            for (int v = 1; v <= 9; v++) {
                if (!check(i, j, v)) continue;
                sudoku[i][j] = v;
                if (j + 1 == 9) {
                    fill(i + 1, 0, depth + 1);
                } else {
                    fill(i, j + 1, depth + 1);
                }
                if(flag) return;
                sudoku[i][j] = 0;
            }
        }
    }


    private static boolean check(int x, int y, int v) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == v) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == v) return false;
        }

        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (sudoku[i][j] == v) return false;
            }
        }
        return true;
    }

}
