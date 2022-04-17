package jhkim.p220302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21608 {

	static int n, total, classroom[][], nx, ny, like, count, blank, space, ansMe;
	static Student[] students;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Student {
		int me, likes[] = new int[4];

		public Student(int me, int[] likes) {
			this.me = me;
			this.likes = likes;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		total = n * n;

		students = new Student[total];
		classroom = new int[n][n];

		int me, one, two, three, four;

		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			me = Integer.parseInt(st.nextToken());
			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			four = Integer.parseInt(st.nextToken());
			students[i] = new Student(me, new int[] { one, two, three, four });
		}

		classroom[1][1] = students[0].me;

		for (int i = 1; i < total; i++) {
			sit(i);
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans += Math.pow(10, finalCheck(i, j) - 1);
			}
		}
		System.out.println(ans);
	}

	private static void sit(int me) {
		int max = 0, maxi = -1, maxj = -1, maxblank = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (classroom[i][j] != 0)
					continue;
				like = check(i, j, me)[0];
				space = check(i, j, me)[1];
				if(maxi == -1 && maxj == -1) {
					maxi = i;
					maxj = j;
				}
				if (max < like) {
					max = like;
					maxblank = space;
					maxi = i;
					maxj = j;
				} else if (max == like) {
					if(maxblank < space) {
						max = like;
						maxblank = space;
						maxi = i;
						maxj = j;
					}else if (maxblank == space) {
						if(maxi > i) {
							max = like;
							maxblank = space;
							maxi = i;
							maxj = j;
						} else if(maxi == i && maxj > j) {
							max = like;
							maxblank = space;
							maxi = i;
							maxj = j;
						}
					}
				}
			}
		}
		classroom[maxi][maxj] = students[me].me;
	}

	private static int[] check(int x, int y, int me) {
		int[] result = new int[2];
		count = 0;
		blank = 0;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			for (int j = 0; j < 4; j++) {
				if (classroom[nx][ny] == students[me].likes[j]) {
					count++;
				}
				if(classroom[nx][ny] == 0) {
					blank++;
				}
			}
		}
		result[0] = count;
		result[1] = blank;
		return result;
	}
	
	private static int finalCheck(int x, int y) {
		count = 0;
		
		for(int i = 0; i < total; i++) {
			if(classroom[x][y] == students[i].me) {
				ansMe = i;
				break;
			}
		}
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			for (int j = 0; j < 4; j++) {
				if (classroom[nx][ny] == students[ansMe].likes[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
