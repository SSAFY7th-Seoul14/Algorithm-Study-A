package jhkim.p220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14889 {

	static int n, min, soccer[][];
	static int[] startTeam, linkTeam;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		soccer = new int[n][n];
		startTeam = new int[n / 2];
		linkTeam = new int[n / 2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				soccer[i][j] = Integer.parseInt(st.nextToken());
				min = Math.max(min, soccer[i][j]);
			}
		}
		combi(0, 0);
		br.close();
		System.out.println(min);
	}

	private static void combi(int start, int count) {
		if (count == n / 2) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (startTeam[j] == i) {
						break;
					} else if (j == n / 2 - 1) {
						linkTeam[cnt] = i;
						cnt++;
					}
				}
			}
			calculate(startTeam, linkTeam);
			return;
		}
		for (int i = start; i < n; i++) {
			startTeam[count] = i;
			combi(i + 1, count + 1);
		}
	}

	private static void calculate(int[] startTeam, int[] linkTeam) {
		int startSum = 0, linkSum = 0, minValue = 0;
		for (int i = 0; i < startTeam.length; i++) {
			for (int j = 0; j < startTeam.length; j++) {
//				if(i == j) continue;
				startSum += soccer[startTeam[i]][startTeam[j]];
			}
		}
		for (int i = 0; i < linkTeam.length; i++) {
			for (int j = 0; j < linkTeam.length; j++) {
//				if(i == j) continue;
				linkSum += soccer[linkTeam[i]][linkTeam[j]];
			}
		}
		minValue = Math.abs(startSum - linkSum);
		if (min > minValue) {
			min = minValue;
		}
	}
}
