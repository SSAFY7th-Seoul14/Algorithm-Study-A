import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2667 {
	static char[][] map;
	static boolean[][] vis;
	static Deque<int[]> q = new ArrayDeque<>();
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int n, move[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!vis[i][j] && map[i][j] == '1') {
					bfs(i, j);					
				}
			}
		}
		result.sort(null);
		System.out.println(result.size());
		for (int num : result) {
			System.out.println(num);			
		}
		br.close();
	}
	
	static void bfs(int startY, int startX) {
		q.offer(new int[] {startY, startX});
		vis[startY][startX] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] here = q.poll();
			int hereY = here[0];
			int hereX = here[1];
			for(int[] next : move) {
				int nextY = hereY + next[0];
				int nextX = hereX + next[1];
				if(0 <= nextY && nextY < n && 0 <= nextX && nextX < n)
				if(!vis[nextY][nextX] && map[nextY][nextX] == '1') {
					vis[nextY][nextX] = true;
					cnt++;
					q.offer(new int[] {nextY, nextX});
				}
			}
		}
		result.add(cnt);
	}
}