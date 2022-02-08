package jhkim.p220208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1406 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> satz = new LinkedList<>();
		LinkedList<Character> temp = new LinkedList<>();
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			satz.offerFirst(str.charAt(i));
		}

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String p = br.readLine();
			if (p.equals("L")) {
				if(!satz.isEmpty()) {
					temp.offerLast(satz.pollFirst());
				}
			} else if (p.equals("D")) {
				if(!temp.isEmpty()) {
					satz.offerFirst(temp.pollLast());
				}
			} else if (p.equals("B")) {
				if(!satz.isEmpty()) {
					satz.pollFirst();
				}
			} else {
				st = new StringTokenizer(p, " ");
				st.nextToken();
				satz.offerFirst(st.nextToken().charAt(0));
			}
		}
		while(!satz.isEmpty()) {
			bw.write(satz.pollLast());
		}
		while(!temp.isEmpty()) {
			bw.write(temp.pollLast());
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}
