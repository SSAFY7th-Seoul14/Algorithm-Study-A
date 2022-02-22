import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int move[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		for (int t = 0; t < T; t++) {
			char[] arr = br.readLine().toCharArray();
			int y1 = 0, x1 = 0, y2 = 0, x2 = 0;
			int hereY = 0, hereX = 0, direction = 0;
			for (char c : arr) {
				switch (c) {
				case 'F':
					hereY += move[direction][0];
					hereX += move[direction][1];
					break;
				case 'B':
					hereY -= move[direction][0];
					hereX -= move[direction][1];
					break;
				case 'L':
					direction = direction == 0 ? 3 : direction - 1;
					break;
				case 'R':
					direction = (direction + 1) % 4;
					break;
				}
				y1 = Math.min(y1, hereY);
				x1 = Math.min(x1, hereX);
				y2 = Math.max(y2, hereY);
				x2 = Math.max(x2, hereX);
			}
			System.out.println((y2 - y1) * (x2 - x1));
		}
		br.close();
	}
}