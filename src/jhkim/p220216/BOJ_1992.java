package jhkim.p220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992 {

	static int n, video[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		video = new int[n][n];
		String str;

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		compress(0, 0, n);
		System.out.println(sb);
	}

	private static void compress(int x, int y, int size) {
		if (isPossible(x, y, size)) {
			sb.append(video[x][y]);
			return;
		}
		size /= 2;
		sb.append("(");
		compress(x, y, size);
		compress(x, y + size, size);
		compress(x + size, y, size);
		compress(x + size, y + size, size);
		sb.append(")");
	}

	private static boolean isPossible(int x, int y, int size) {
		int value = video[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (value != video[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
