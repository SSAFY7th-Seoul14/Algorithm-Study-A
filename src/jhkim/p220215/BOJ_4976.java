package jhkim.p220215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4976 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int l, p, v, days = 0;
		int tc = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			if (l == 0 && p == 0 && v == 0)
				break;

			days = l * (v / p);
			v = v % p;
			if (v < l) {
				days += v;
			} else if (v >= l) {
				days += l;
			}
			bw.write("Case " + tc + ": " + days + "\n");
			tc++;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
