import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11725 {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static boolean[] vis;
	static int[] result;
	static Deque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		vis = new boolean[n+1];
		result = new int[n+1];
		for (int i = 0; i < n+1; i++) tree.add(new ArrayList<Integer>());
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		bfs(1);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n+1; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void bfs(int start) {
		q.offer(start);
		vis[start] = true;
		while(!q.isEmpty()) {
			int here = q.poll();
			for (Integer node : tree.get(here)) {
				if(!vis[node]) {
					q.offer(node);
					vis[node] = true;
					result[node] = here;
				}
			}
		}
	}
}
