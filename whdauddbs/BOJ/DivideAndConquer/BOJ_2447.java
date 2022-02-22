import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
	static int n;
	static StringBuilder sb[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			sb[i] = new StringBuilder();
		}
		go(true, 0, n);
		for (int i = 0; i < n; i++) {
			System.out.println(sb[i].toString());
		}
		br.close();
	}
	
	static void go(boolean flag, int y1, int y2) {
		if(y1 + 1 == y2) {
			sb[y1].append(flag ? "*" : " ");
			return;
		}
		int part = (y2 - y1) / 3;
		go(flag, y1, y1 + part);
		go(flag, y1, y1 + part);
		go(flag, y1, y1 + part);
		go(flag, y1 + part, y2 - part);
		go(false, y1 + part, y2 - part);
		go(flag, y1 + part, y2 - part);
		go(flag, y2 - part, y2);
		go(flag, y2 - part, y2);
		go(flag, y2 - part, y2);
	}
}