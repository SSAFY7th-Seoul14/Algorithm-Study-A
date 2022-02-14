package jhkim.p220213;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_1913 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = input.nextInt();
		int num = input.nextInt();

		int[][] table = new int[n][n];

		int[] dx = { -1, 0, 1, 0 }; // 상우하좌순
		int[] dy = { 0, 1, 0, -1 }; // 상우하좌순

		int idx = 0;
		int x = n / 2;
		int y = n / 2;
		int i = 1, times = 1;
		int numX = 0, numY = 0;

		outer: while (true) {
			for(int k = 0; k < 2; k++) {
				for (int j = 0; j < times; j++) {
					table[x][y] = i++;
					if (i > n * n)
						break outer;
					x += dx[idx];
					y += dy[idx];
				}
				idx++;
				if(idx == 4) idx = 0;
			}
			times++;
		}
		for (int h = 0; h < n; h++) {
			for (int w = 0; w < n; w++) {
				if (table[h][w] == num) {
					numX = h;
					numY = w;
				}
				bw.write(table[h][w] + " ");
			}
			bw.newLine();
		}
		bw.write((numX + 1) + " " + (numY + 1));

		bw.flush();
		bw.close();
	}
}
