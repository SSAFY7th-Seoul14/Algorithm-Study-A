package jhkim.p220214;

import java.util.Scanner;

public class BOJ_10448 {

	static int k;
	static int[] t1 = new int[45];
	static int[] t2 = new int[45];
	static int[] t3 = new int[45];

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		for (int i = 1; i < 45; i++) {
			t1[i] = (i * (i + 1)) / 2;
			t2[i] = (i * (i + 1)) / 2;
			t3[i] = (i * (i + 1)) / 2;
		}

		for (int i = 0; i < t; i++) {
			k = input.nextInt();
			System.out.println(eureka(k));
		}

	}

	private static int eureka(int k) {
		for (int a = 1; a < 45; a++) {
			for (int b = 1; b < 45; b++) {
				for (int c = 1; c < 45; c++) {
					if(t1[a] + t2[b] + t3[c] == k) return 1;
				}
			}
		}
		return 0;
	}

}
