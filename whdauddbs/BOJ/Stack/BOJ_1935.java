import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1935 {
	
	public static void main(String[] args) throws IOException {
		HashMap<Character, Double> map = new HashMap<>();
		Stack<Double> stack = new Stack<Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] exp = br.readLine().toCharArray();
		for (int i = 0; i < n; i++) {
			map.put((char)('A'+i), Double.parseDouble(br.readLine()));
		}
		for (char c : exp) {
			if(map.get(c) != null) {
				stack.add(map.get(c));
			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				switch(c) {
					case '+':
						stack.add(num1 + num2);
						break;
					case '-':
						stack.add(num1 - num2);
						break;
					case '/':
						stack.add(num1 / num2);
						break;
					case '*':
						stack.add(num1 * num2);
						break;
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
		br.close();
	}
}
