import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
	static ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
	static int maxVal = 0, maxNode = 0;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n+1; i++) tree.add(new ArrayList<int[]>());
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree.get(a).add(new int[] {b, w});
			tree.get(b).add(new int[] {a, w});
		}
		vis = new boolean[n+1];
		dfs(1, 0);
		maxVal = 0;
		vis = new boolean[n+1];
		dfs(maxNode, 0);
		System.out.println(maxVal);
		br.close();
	}
	
	static void dfs(int here, int weight) {
		vis[here] = true;
		for (int[] node : tree.get(here)) {
			if(!vis[node[0]]) {
				dfs(node[0], weight + node[1]);
			}
		}
		if(maxVal < weight) {
			maxVal = weight;
			maxNode = here;
		}
	}
}
