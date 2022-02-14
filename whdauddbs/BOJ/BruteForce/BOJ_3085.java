import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
	static int n, maxResult = 0;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				searchHorizontal(i, j);
				searchVertical(i, j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j+1 < n && board[i][j] != board[i][j+1]) {
					swap(i, j, i, j+1);
					searchVertical(i,j);
					searchVertical(i,j+1);
					searchHorizontal(i, j);
					searchHorizontal(i, j+1);
					swap(i, j, i, j+1);					
				}
				if(i+1 < n && board[i][j] != board[i+1][j]) {
					swap(i, j, i+1, j);
					searchHorizontal(i, j);
					searchHorizontal(i+1, j);
					searchVertical(i,j);
					searchVertical(i+1,j);
					swap(i, j, i+1, j);	
				}
			}
		}
		System.out.println(maxResult);
		br.close();
	}
	
	static void searchHorizontal(int y, int x) {
		int result = 0;
		for (int k = x; k < n && board[y][x] == board[y][k]; k++) {
			result++;
		}
		for (int k = x-1; k >= 0 && board[y][x] == board[y][k]; k--) {
			result++;
		}
		maxResult = Math.max(maxResult, result);
	}
	
	static void searchVertical(int y, int x) {
		int result = 0;
		for (int k = y; k < n && board[y][x] == board[k][x]; k++) {
			result++;
		}
		for (int k = y-1; k >= 0 && board[y][x] == board[k][x]; k--) {
			result++;
		}
		maxResult = Math.max(maxResult, result);
	}
	
	static void swap(int y1, int x1, int y2, int x2) {
		char temp = board[y1][x1];
		board[y1][x1] = board[y2][x2];
		board[y2][x2] = temp;
	}
}