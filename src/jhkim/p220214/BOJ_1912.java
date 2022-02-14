package jhkim.p220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {

	static int n, num[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = num[0];
		int[] result = new int[n];
		result[0] = num[0];
		for(int i = 1; i < n; i++) {
			if(result[i - 1] + num[i] < num[i]) {
				result[i] = num[i];
			} else {
				result[i] = result[i-1] + num[i];
			}
			max = Math.max(result[i], max);
		}
		
		System.out.println(max);
	}

}
