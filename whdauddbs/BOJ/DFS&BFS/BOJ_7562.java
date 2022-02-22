import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_7562 {
	static int l, dtX, dtY;
	static int[][] move = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, 
			{1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static boolean[][] vis;
	static Deque<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			l = Integer.parseInt(br.readLine()); 
			vis = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hereX = Integer.parseInt(st.nextToken());
			int hereY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			dtX = Integer.parseInt(st.nextToken());
			dtY = Integer.parseInt(st.nextToken());
			bfs(hereY, hereX);
			q.clear();
		}
		br.close();
	}
	static void bfs(int startY, int startX) {
		q.offer(new int[] {startY, startX, 0});
		vis[startY][startX] = true;
		while(!q.isEmpty()) {
			int[] here = q.poll();
			int hereY = here[0];
			int hereX = here[1];
			int cnt = here[2];
			if(hereY == dtY && hereX == dtX) {
				System.out.println(cnt);
				return;
			}
			for(int[] next : move) {
				int nextY = hereY + next[0];
				int nextX = hereX + next[1];
				if(0 <= nextY && nextY < l && 0 <= nextX && nextX < l) {
					if(!vis[nextY][nextX]) {
						vis[nextY][nextX] = true;
						q.offer(new int[] {nextY, nextX, cnt+1});
					}
				}
			}
		}
	}
}