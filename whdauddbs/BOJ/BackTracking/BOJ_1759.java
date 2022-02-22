import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int l, c, aCnt = 0, bCnt = 0;
	static char[] arr, result;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		result = new char[l];
		arr = new char[c];
		vis = new boolean[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		go(0, 0);
		System.out.println(sb.toString());
		br.close();
	}
	
	static void go(int cnt, int start) {
		if(cnt == l) {
			if (aCnt >= 1 && bCnt >= 2) {
				sb.append(result).append("\n");
			}
			return;
		}
		for (int i = start; i < c; i++) {
			if(vis[i]) continue;
			vis[i] = true;
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				aCnt++;
			else
				bCnt++;
			result[cnt] = arr[i];
			go(cnt+1, i+1);
			vis[i] = false;
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				aCnt--;
			else
				bCnt--;
		}
		
	}
}