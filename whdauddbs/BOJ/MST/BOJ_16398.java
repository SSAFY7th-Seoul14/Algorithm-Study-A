import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge{
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

public class BOJ_16398 {
	static int n, parents[];
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {				
				int cost = Integer.parseInt(st.nextToken());
				if(j > i) {
					edge.add(new Edge(i, j, cost));									
				}
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
}
