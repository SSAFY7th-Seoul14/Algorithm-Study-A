package jhkim.p220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
	static int count = 0;
	static long a, b, c;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());

		System.out.println(multiplize(a, b));
	}

	private static long multiplize(long a, long b) {
		
		if(b == 1) {
			return a % c;
		}
		long temp = multiplize(a, b/2);
		
		if(b%2 == 1) {
			return (temp*temp%c) * a % c;
		}
		return temp*temp%c;
	}
}
