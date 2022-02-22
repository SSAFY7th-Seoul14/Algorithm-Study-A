import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] vis;
	static Deque<Integer> q = new ArrayDeque<>();
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		vis = new boolean[n+1];
		for (int i = 0; i < n+1; i++) graph.add(new ArrayList<Integer>());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for (int i = 0; i < n+1; i++) graph.get(i).sort(null);
		vis[v] = true;
		dfs(v);
		vis = new boolean[n+1];
		result.append("\n");
		bfs(v);
		System.out.println(result.toString());
		br.close();
	}
	
	static void dfs(int here) {
		result.append(here + " ");
		for(int next : graph.get(here)) {
			if(!vis[next]) {
				vis[next] = true;
				dfs(next);
			}
		}
	}
	
	static void bfs(int start) {
		q.offer(start);
		vis[start] = true;
		while(!q.isEmpty()) {
			int here = q.poll();
			result.append(here + " ");
			for(int next : graph.get(here)) {
				if(!vis[next]) {
					vis[next] = true;
					q.offer(next);
				}
			}
		}
	}
}