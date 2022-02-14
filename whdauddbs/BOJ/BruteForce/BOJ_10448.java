import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ_10448 {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> tArr = new ArrayList<Integer>();
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 1; i * (i+1) / 2 <= 1000; i++) {
			tArr.add(i*(i+1)/2);
		}
		for (int i = 0; i < tArr.size(); i++) {
			for (int j = 0; j < tArr.size(); j++) {
				for (int k = 0; k < tArr.size(); k++) {
					int sum = tArr.get(i) + tArr.get(j) + tArr.get(k);
					if(sum <= 1000) {
						map.put(sum, true);
					}
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(map.get(num) != null ? "1\n":"0\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}