import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l == 0 && p == 0 && v == 0) break;
			
			int result = v / p * l + Math.min(v % p, l);
			System.out.printf("Case %d: %d\n", t++, result);
		}
	}
}