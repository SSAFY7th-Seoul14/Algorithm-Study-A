import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1922 {
	static int n, m, parents[];
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge.add(new Edge(a, b, c));
		}
		edge.sort((o1, o2) -> o1.cost - o2.cost);
		int result = 0;
		for (Edge e : edge) {
			if(find(e.a) != find(e.b)) {
				union(e.a, e.b);
				result += e.cost;
			}
		}
		System.out.println(result);
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
