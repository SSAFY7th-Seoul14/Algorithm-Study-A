import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
	
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] exp = br.readLine().toCharArray();
		for (char c : exp) {
			if(c == '+' || c == '-') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					System.out.print(stack.pop());
				}
				stack.push(c);
			} else if(c == '*' || c == '/') {
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					System.out.print(stack.pop());
				}
				stack.push(c);
			} else if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') System.out.print(stack.pop());
				stack.pop();
			} else {
				System.out.print(c);
			}
		}
		while(!stack.isEmpty()) System.out.print(stack.pop());
		br.close();
	}
}
