import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11728 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(n);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(m);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			pq2.add(Integer.parseInt(st.nextToken()));
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!pq1.isEmpty() || !pq2.isEmpty()) {
			if(pq1.isEmpty()) {
				sb.append(pq2.poll() + " ");
			} else if(pq2.isEmpty()) {
				sb.append(pq1.poll() + " ");
			} else if(pq1.peek() >= pq2.peek()) {
				sb.append(pq2.poll() + " ");
			} else if(pq1.peek() <= pq2.peek()) {
				sb.append(pq1.poll() + " ");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}