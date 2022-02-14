import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1966 {
	
	public static void main(String[] args) throws IOException {
		Queue<int[]> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			q.clear();
			pq.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(new int[] {j, num});
				pq.offer(num);
			}
			int cnt = 0;
			while(true) {
				if(q.peek()[1] == pq.peek()) {
					cnt++;
					if(q.peek()[0] == m) {
						break;
					}
					q.poll();
					pq.poll();
				} else {
					q.offer(q.poll());
				}
			}
			System.out.println(cnt);
		}
		br.close();
	}
}
