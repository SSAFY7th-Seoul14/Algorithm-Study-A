package jhkim.p220312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {

	static int N, M, paper[][], max;
	static boolean visited[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paper = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				tetromino(i, j, 1, paper[i][j], false, visited);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}

	private static void tetromino(int x, int y, int count, int sum, boolean back, boolean[][] visited) {
		if (count >= 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= N || nx < 0 || ny >= M || ny < 0)
				continue;
			if (visited[nx][ny]) {
				if (count == 3 && !back) {
					tetromino(nx, ny, count, sum, true, visited);
				} else if(count == 3 && back) return;
			} else {
				visited[nx][ny] = true;
				tetromino(nx, ny, count + 1, sum + paper[nx][ny], back, visited);
				visited[nx][ny] = false;
			}
		}
	}
}
