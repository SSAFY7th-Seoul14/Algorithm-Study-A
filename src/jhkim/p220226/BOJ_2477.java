package jhkim.p220226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		short[][] map = new short[1001][1001];

		int dir, length;

		int start = 500, end = 500;
		int top = 0, bottom = 1001, left = 1001, right = 0;
		int midh = 0, midw = 0;
		int width, height;
		int minwidth = 0, minheight = 0;

		map[start][end] = 1;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			length = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				end -= length;
				map[start][end] = 1;
				break;
			case 2:
				end += length;
				map[start][end] = 1;
				break;
			case 3:
				start += length;
				map[start][end] = 1;
				break;
			case 4:
				start -= length;
				map[start][end] = 1;
				break;
			}
		}

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (map[i][j] == 1) {
					top = Math.max(top, i);
					bottom = Math.min(bottom, i);
					left = Math.min(left, j);
					right = Math.max(right, j);
				}
			}
		}

		width = right - left;
		height = top - bottom;

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (map[i][j] == 1) {
					if (i != top && i != bottom) {
						if (j != left && j != right) {
							midh = i;
							midw = j;
						}
					}
				}
			}
		}

		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (map[i][j] == 1) {
					if (i == midh && j != midw) {
						if (j == left) {
							if (map[top][left] == 0) {
								minheight = top - midh;
							} else if (map[bottom][left] == 0) {
								minheight = midh - bottom;
							}
						}
						if (j == right) {
							if (map[top][right] == 0) {
								minheight = top - midh;
							} else if (map[bottom][right] == 0) {
								minheight = midh - bottom;
							}
						}
					}
					if (j == midw && i != midh) {
						if (i == top) {
							if (map[top][left] == 0) {
								minwidth = midw - left;
							} else if (map[top][right] == 0) {
								minwidth = right - midw;
							}
						}
						if (i == bottom) {
							if (map[bottom][left] == 0) {
								minwidth = midw - left;
							} else if (map[bottom][right] == 0) {
								minwidth = right - midw;
							}
						}
					}
				}
			}
		}
		System.out.println(k * ((width * height) - (minheight * minwidth)));
	}
}
