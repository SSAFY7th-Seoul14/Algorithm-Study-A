package jhkim.p220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922 {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int n, parents[];
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int from, to, weight;
		
		parents = new int[n + 1];
		
		for(int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}
		
		edgeList = new Edge[m];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList);
		
		int result = 0, cnt = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == n) break;
			}
		}
		System.out.println(result);
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
