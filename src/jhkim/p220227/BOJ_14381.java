package jhkim.p220227;

import java.util.Scanner;

public class BOJ_14381 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int originN, n, result = 0, temp;
		boolean[] digits = new boolean[10];
		
		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			originN = n;
			digits = new boolean[10];
			if(n == 0) {
				System.out.println("Case #" + tc + ": INSOMNIA");
			} else {
				outer: while(true) {
					temp = n;
					while(temp >= 10) {
						digits[temp % 10] = true;
						temp /= 10;
					}
					digits[temp] = true;
					for(int i = 0; i < 10; i++) {
						if(!digits[i]) break;
						if(i == 9 && digits[9]) {
							result = n;
							break outer;
						}
					}
					n += originN;
				}
				System.out.println("Case #" + tc + ": " + result);
			}
		}
	}
}
