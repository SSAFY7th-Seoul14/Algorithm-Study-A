package jhkim.p220210;

import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] papers = new int[100][100];

		int x, y;
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			x = input.nextInt();
			y = input.nextInt();
			
			for(int w = x; w < x + 10; w++) {
				for(int h = y; h < y + 10; h++) {
					papers[w][h] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(papers[i][j] == 1) count++;
			}
		}
		System.out.println(count);
	}
}
