package jhkim.p220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16398 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int planets[][] = new int[n + 1][n + 1];
		int minEdge[] = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				planets[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		long result = 0;
		minEdge[1] = 0;
		
		for(int c = 1; c < n + 1; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for(int i = 1; i < n + 1; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			visited[minVertex] = true;
			result += min;
			
			for(int i = 1; i < n + 1; i++) {
				if(!visited[i] && minEdge[i] > planets[minVertex][i]) {
					minEdge[i] = planets[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}
}
