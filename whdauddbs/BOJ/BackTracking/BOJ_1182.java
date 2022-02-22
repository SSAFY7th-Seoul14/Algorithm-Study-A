import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int n, s, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = counting(0, 0);
		System.out.println(s == 0 ? result - 1 : result);
		br.close();
	}
	
	static int counting(int idx, int sum) {
		if(idx == n) {
			if(sum ==s) return 1;
			return 0;
		}
		return counting(idx + 1, sum) + counting(idx + 1, sum + arr[idx]);
	}
}