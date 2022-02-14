import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16437_BFS {
	static Deque<Integer> q = new ArrayDeque<>();
	static int[] parent, indegree;
	static long[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		cnt = new long[n+1];
		indegree = new int[n+1];
		for (int i = 2; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char t = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			parent[i]= p;
			indegree[p]++;
			cnt[i] = t == 'S' ? a : -a;
		}
		for (int here = 1; here < indegree.length; here++) {
			if(indegree[here] == 0) q.offer(here);
		}
		while(!q.isEmpty()) {
			int here = q.poll();
			if(indegree[here] == 0) {
				int next = parent[here];
				if(cnt[here] > 0) {
					cnt[next] += cnt[here];
				}
				if(--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		System.out.println(cnt[1]);
		br.close();
	}
}
