import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_10597 {
	static char[] arr; // 입력값
	static boolean[] vis; // 수를 이전에 찾았는지 여부 저장
	static int n; // 범위
	static Deque<Integer> result = new ArrayDeque<>(); // 결과값 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		n = arr.length < 10 ? arr.length : (arr.length - 8) / 2 + 9; // 범위 찾기
		vis = new boolean[n+1];
		go(0);
		StringBuilder sb = new StringBuilder();
		while(!result.isEmpty()) sb.append(result.removeLast() + " ");
		System.out.println(sb.toString());
	}
	
	static boolean go(int here) {
		if(arr[here] == '0') return false; // 시작이 0 처리
		for(int i = here+1; i < here + 3 && i <= arr.length; i++) {
			int num = Integer.parseInt(new String(Arrays.copyOfRange(arr, here, i)));
//			System.out.println(num);
			if(0 < num && num <= n && !vis[num]) {
				result.push(num);
				vis[num] = true;
				if(i == arr.length) {
					return true;
				}
				if(go(i)) {
					return true;
				}
				vis[num] = false;	
				result.pop();
			}				
		}
		return false;
	}
}