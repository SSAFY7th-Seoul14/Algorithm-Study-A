import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16437 {
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		cnt = new int[n+1];
		for(int i = 0; i < n+1; i++) tree.add(new ArrayList<Integer>());
		
		for (int i = 2; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char t = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			tree.get(p).add(i);
			cnt[i] = t == 'S' ? a : -a;
		}
		System.out.println(dfs(1));
		br.close();
	}
	
	static long dfs(int here) {
		long result = cnt[here];
		for (int next : tree.get(here)) {
			long sheep = dfs(next);
			result += sheep > 0 ? sheep : 0;
		}
		return result;
	}
}
