package jhkim.p220215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
	
	static int count = 1, n;
	static Meeting[] meetings;
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		meetings = new Meeting[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meetings);
		
		getSchedule();
		
		System.out.println(count);

	}
	
	private static void getSchedule() {
		int curr = 0;
		for(int i = 1; i < n; i++) {
			if(meetings[curr].end <= meetings[i].start) {
				count++;
				curr = i;
			}
		}
	}

}
