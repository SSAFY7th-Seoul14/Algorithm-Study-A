package jhkim.p220213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	
	static int n, r;
	static char[] password, result;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		st = new StringTokenizer(str);
		r = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		password = new char[n];
		result = new char[r];
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for(int i = 0; i < n; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(password);
		passwords(0, 0, 0, 0);
		bw.flush();
		br.close();
		bw.close();
	}

	private static void passwords(int count, int start, int vowel, int consonant) throws IOException {
		if(count == r) {
			if(vowel >= 1 && consonant >= 2) {
				for(int i = 0; i < r; i++) {
					bw.write(result[i]);
				}
				bw.newLine();
			}
			return;
		}
		for(int i = start; i < n; i++) {
			if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
				result[count] = password[i];
				passwords(count + 1, i + 1, vowel + 1, consonant);
			} else {
				result[count] = password[i];
				passwords(count + 1, i + 1, vowel, consonant + 1);
			}
		}
	}
}
