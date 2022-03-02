package jhkim.p220302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {

	static int n, nx, ny;
	static char color;
	static char[][] chart;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		String str;
		chart = new char[n][n];

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < n; j++) {
				chart[i][j] = str.charAt(j);
			}
		}
		System.out.print(normal() + " " + rbBlind());
	}

	private static int normal() {
		visited = new boolean[n][n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				else {
					visited[i][j] = true;
					check(i, j);
					result++;
				}
			}
		}
		return result;
	}

	private static void check(int x, int y) {
		color = chart[x][y];
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx >= n || ny >= n || nx < 0 || ny < 0) {
				continue;
			}
			if (chart[nx][ny] == color && !visited[nx][ny]) {
				visited[nx][ny] = true;
				check(nx, ny);
			} else
				continue;
		}
	}

	private static int rbBlind() {
		visited = new boolean[n][n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				else {
					visited[i][j] = true;
					checkBlind(i, j);
					result++;
				}
			}
		}
		return result;
	}

	private static void checkBlind(int x, int y) {
		color = chart[x][y];
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx >= n || ny >= n || nx < 0 || ny < 0) {
				continue;
			}
			if (color == 'B') {
				if (chart[nx][ny] == color && !visited[nx][ny]) {
					visited[nx][ny] = true;
					checkBlind(nx, ny);
				} else
					continue;
			}
			if (color == 'R' || color == 'G') {
				if ((chart[nx][ny] == 'R' || chart[nx][ny] == 'G') && !visited[nx][ny]) {
					visited[nx][ny] = true;
					checkBlind(nx, ny);
				} else
					continue;
			}
		}
	}
}
