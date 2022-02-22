import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16397 {
	static boolean[] vis;
	static Deque<int[]> q = new ArrayDeque<>();
	static int result = -1, t, g;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		vis = new boolean[100000];
		
		result = bfs(n);
		System.out.println(result == -1 ? "ANG" : result);
		br.close();
	}
	
	static int bfs(int start) {
		q.offer(new int[] {start, 0});
		vis[start] = true;
		while(!q.isEmpty()) {
			int[] here = q.poll();
			int cnt = here[1];
			if(cnt > t) return -1;
			if(here[0] == g) return cnt;
			int next = here[0] + 1;
			if(next <= 99999 && !vis[next]) {
				vis[next] = true;
				q.offer(new int[] {next, cnt+1});
			}
			next =  here[0] * 2;
			if(next <= 99999) {
				next -= (int)Math.pow(10, (int)Math.log10(next));
				if(next <= 99999 && !vis[next]) {
					vis[next] = true;
					q.offer(new int[] {next, cnt+1});
				}
			}
		}
		return -1;
	}
}