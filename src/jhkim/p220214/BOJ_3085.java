package jhkim.p220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
	static int n;
	static char candies[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		candies = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				candies[i][j] = str.charAt(j);
			}
		}
		char temp;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				horizontalCheck(i, j);
				verticalCheck(i, j);
				if(j < n - 1) {
					temp = candies[i][j];
					candies[i][j] = candies[i][j + 1];
					candies[i][j + 1] = temp;
					verticalCheck(i, j);
					verticalCheck(i, j + 1);
					horizontalCheck(i, j);
					horizontalCheck(i, j + 1);
					temp = candies[i][j];
					candies[i][j] = candies[i][j + 1];
					candies[i][j + 1] = temp;
				} else {
					verticalCheck(i, j);
					horizontalCheck(i, j);
				}
				
				if(i < n - 1) {
					temp = candies[i][j];
					candies[i][j] = candies[i + 1][j];
					candies[i + 1][j] = temp;
					horizontalCheck(i, j);
					horizontalCheck(i + 1, j);
					verticalCheck(i, j);
					verticalCheck(i + 1, j);
					temp = candies[i][j];
					candies[i][j] = candies[i + 1][j];
					candies[i + 1][j] = temp;
				} else {
					horizontalCheck(i, j);
					verticalCheck(i, j);
				}
			}
		}
		System.out.println(max);
	}
	static int count = 1;
	static int max = 0;

	private static void horizontalCheck(int x, int y) {
		count = 1;
		for(int i = 0; i < n - 1; i++) {
			if(candies[x][i] == candies[x][i + 1]) {
				count++;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}
	}
	private static void verticalCheck(int x, int y) {
		count = 1;
		for(int i = 0; i < n - 1; i++) {
			if(candies[i][y] == candies[i + 1][y]) {
				count++;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}
	}


}
