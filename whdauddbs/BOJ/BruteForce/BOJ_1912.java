import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result= new int[n];
		int maxResult;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		result[0] = maxResult = arr[0];
		for (int i = 1; i < n; i++) {
			result[i] = Math.max(result[i-1] + arr[i], arr[i]);
			maxResult = Math.max(maxResult, result[i]);
		}
		System.out.println(maxResult);
		br.close();
	}
}