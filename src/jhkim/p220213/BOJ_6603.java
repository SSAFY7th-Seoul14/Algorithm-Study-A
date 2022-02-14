package jhkim.p220213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int n;
	static int[] nums;
	static int[] result = new int[6];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str;
		
		while(true) {
			str = br.readLine();
			if(str.equals("0")) break;
			
			st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			lotto(0, 0);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static void lotto(int count, int start) throws IOException {
		if(count == 6) {
			for (int i : result) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		for(int i = start; i < n; i++) {
			result[count] = nums[i];
			lotto(count + 1, i + 1);
		}
	}
	
}
