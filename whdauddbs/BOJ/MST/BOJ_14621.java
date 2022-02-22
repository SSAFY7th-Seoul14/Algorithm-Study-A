import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14621 {
	static int n, m, parents[];
	static char univ[];
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		univ = new char[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
			univ[i] = st.nextToken().charAt(0);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(univ[a] != univ[b]) {
				edge.add(new Edge(a, b, cost));													
			}
		}
		edge.sort((o1, o2) -> o1.cost - o2.cost);
		long result = 0;
		for (Edge e : edge) {
			if(find(e.a) != find(e.b)) {
				union(e.a, e.b);
				result += e.cost;
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			set.add(find(i));
		}
		System.out.println(set.size() != 1 ? -1 : result);
		br.close();
	}
	
	private static int find(int node) {
		if(parents[node] == node) {
			return node;
		} else {
			return parents[node] = find(parents[node]);
		}
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
	}
	
	static class Edge{
		int a, b, cost;
		
		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return a + " - " + b + " : " + cost;
		}
	}
}
