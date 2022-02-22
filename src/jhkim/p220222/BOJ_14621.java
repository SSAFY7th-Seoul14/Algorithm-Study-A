package jhkim.p220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14621 {

	static class Uni implements Comparable<Uni> {
		int from, to, distance;

		public Uni(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Uni o) {
			return this.distance - o.distance;
		}
	}

	static int[][] unis;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		unis = new int[n + 1][2];
		int from, to, distance;
		Uni[] map = new Uni[m];

		for (int i = 1; i < n + 1; i++) {
			unis[i][0] = i;
			unis[i][1] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			distance = Integer.parseInt(st.nextToken());
			map[i] = new Uni(from, to, distance);
		}

		Arrays.sort(map);

		int result = 0, count = 0;

		for (Uni uni : map) {
			if (unis[uni.from][1] != unis[uni.to][1] && union(uni.from, uni.to)) {
				result += uni.distance;
				count++;
			}
		}
		
		if(count != n - 1) result = -1;

		System.out.println(result);

	}

	public static int find(int a) {
		if (unis[a][0] == a)
			return a;
		return unis[a][0] = find(unis[a][0]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		unis[bRoot][0] = aRoot;
		return true;
	}
}
