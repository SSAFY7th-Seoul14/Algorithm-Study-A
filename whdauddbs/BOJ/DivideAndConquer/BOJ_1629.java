import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1629 {
	static int a,b,c;
	static HashMap<Integer, Long> mem = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		System.out.println(square(b));
		br.close();
	}
	
	static long square(int n) {
		if(n == 1) return a % c;
		if(mem.get(n) != null) return mem.get(n);
		if(n % 2 == 0) {
			long result = square(n/2) % c * square(n/2) % c;
			mem.put(n, result);
			return result;
		} else {
			long result = square(n/2) % c * square(n/2) % c * a % c;
			mem.put(n, result);
			return result;
		}
	}
}