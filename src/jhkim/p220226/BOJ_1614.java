package jhkim.p220226;

import java.util.Scanner;

public class BOJ_1614 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int injured = sc.nextInt();
		long times = sc.nextLong();
		long result = 0;

		if (injured != 1 && injured != 5) {
			if (times == 0) {
				result = injured - 1;
			} else if (times % 2 == 1) {
				result = (times / 2) * 8 + injured + (5 - injured) * 2 - 1;
			} else if (times % 2 == 0) {
				result = (times / 2) * 8 + injured - 1;
			}
		} else if (injured == 1) {
			if (times == 0) {
				result = injured - 1;
			} else {
				result = times * 8;
			}
		} else if (injured == 5) {
			if (times == 0) {
				result = injured - 1;
			} else {
				result = times * 8 + 4;
			}
		}
		System.out.println(result);
	}
}
