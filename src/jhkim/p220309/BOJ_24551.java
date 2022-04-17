package jhkim.p220309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24551 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		long[] muls = { 111L, 11111L, 1111111L, 11111111111L, 1111111111111L, 11111111111111111L };
		int[] len = { 3, 5, 7, 11, 13, 17 };

		long N = Long.parseLong(str);

		long ans = 0;

		int mul = str.length();
		int times = 0;

		for (int i = 0; i < 6; i++) {
			if (mul >= len[i]) {
				times = i + 1;
			}
		}

		ans += N / 11L;

		for (int i = 0; i < times; i++) {
			ans += N / muls[i];
			ans -= N / (muls[i] * 11L);
		}

		for (int i = 0; i < times; i++) {
			long num1 = muls[i];
			for (int j = i + 1; j < times; j++) {
				long num2 = muls[j];
				long num = num1 * num2;
				if (num > N || len[i] + len[j] - 1 > mul)
					break;
				ans -= N / num;
				ans += N / (num * 11L);
			}
		}

		for (int i = 0; i < times; i++) {
			long num1 = muls[i];
			for (int j = i + 1; j < times; j++) {
				long num2 = muls[j];
				for (int k = j + 1; k < times; k++) {
					long num3 = muls[k];
					long num = num1 * num2 * num3;
					if (num > N || len[i] + len[j] + len[k] - 2 > mul)
						break;

					ans += N / (num);
					ans -= N / (num * 11L);
				}
			}
		}
		System.out.println(ans);
	}
}
