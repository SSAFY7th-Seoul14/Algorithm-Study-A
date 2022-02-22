import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2887 {
	static int n, parents[], planet[][][];
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parents = new int[n];
		planet = new int[3][n][2];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		for (int j = 0; j < n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				planet[i][j][0] = j;
				planet[i][j][1] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			Arrays.sort(planet[i], (o1, o2) -> o1[1] - o2[1]);
			for (int j = 1; j < n; j++) {
				int a = planet[i][j-1][0];
				int b = planet[i][j][0];
				int cost = Math.abs(planet[i][j-1][1] - planet[i][j][1]);
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
