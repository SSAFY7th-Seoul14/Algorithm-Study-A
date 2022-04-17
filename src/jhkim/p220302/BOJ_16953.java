package jhkim.p220302;

import java.util.Scanner;

public class BOJ_16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int result = 1;

		while (true) {
			if(b == a) {
				break;
			}
			if(b < a) {
				result = -1;
				break;
			}

			if (b % 2 == 0) {
				b /= 2;
			} else if (b % 10 != 1) {
				result = -1;
				break;
			} else {
				b /= 10;
			}
			result++;
		}
		System.out.println(result);
	}
}
