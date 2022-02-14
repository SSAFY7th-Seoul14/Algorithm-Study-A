import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_2164 {
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());				
		}
		System.out.println(q.poll());
		br.close();
	}
}
