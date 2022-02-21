package jhkim.p220221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static ArrayList<Integer>[] nodes;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int from, to;

		nodes = new ArrayList[n + 1];

		for(int i = 1; i <=n; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			nodes[from].add(to);
			nodes[to].add(from);
		}

		for(int i = 1; i <=n; i++) {
			Collections.sort(nodes[i]);
		}
		
		visited = new boolean[n + 1];
		dfs(v);
		bw.newLine();
		bfs(v);
		bw.flush();
		br.close();
		bw.close();
	}
	
	static boolean[] visited;

	private static void dfs(int v) throws IOException {
		if(visited[v]) return;
		visited[v] = true;
		bw.write(v + " ");

		for (int i : nodes[v]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		
	}

	private static void bfs(int v) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n + 1];

		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			bw.write(current + " ");

			for (int i : nodes[current]) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}
