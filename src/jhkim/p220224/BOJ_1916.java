package jhkim.p220224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
	
	static class Bus implements Comparable<Bus>{
		int to, fee;

		public Bus(int to, int fee) {
			this.to = to;
			this.fee = fee;
		}
		
		@Override
		public int compareTo(Bus o) {
			return this.fee - o.fee;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] city = new int[n][n];
		ArrayList<Bus>[] buses = new ArrayList[m];
		
		for(int i = 0; i < m; i++) {
			buses[i] = new ArrayList<>();
		}
		
		int from, to, fee;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			fee = Integer.parseInt(st.nextToken());
			buses[from].add(new Bus(to, fee));
		}
		
		int[] fees = new int[n];
		Arrays.fill(fees, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		PriorityQueue<Bus> pqueue = new PriorityQueue<>();
		fees[start] = 0;
		pqueue.offer(new Bus(start, fees[start]));
		
		while(!pqueue.isEmpty()) {
			Bus current = pqueue.poll();
			
			if(current.to == end) break;
			
			for (Bus bus : buses[current.to]) {
				if(fees[bus.to] > fees[current.to] + bus.fee) {
					fees[bus.to] = fees[current.to] + bus.fee;
					pqueue.offer(new Bus(bus.to, fees[bus.to]));
				}
			}
		}
		br.close();
		System.out.println(fees[end]);
	}
}
