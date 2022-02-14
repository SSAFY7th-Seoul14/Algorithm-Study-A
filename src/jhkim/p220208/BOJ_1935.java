package jhkim.p220208;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1935 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		String str = input.next();
		double num1, num2 = 0;
		double result = 0;
		HashMap<Character, Double> alphabet = new HashMap<>();

		Stack<Double> chars = new Stack<>();

		for(int i = 0; i < n; i++) {
			alphabet.put((char)('A' + i), input.nextDouble());
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				chars.push(alphabet.get(str.charAt(i)));
			} else if(str.charAt(i) == '+') {
				num2 = chars.pop();
				num1 = chars.pop();
				result = num1 + num2;
				chars.push(result);
			} else if(str.charAt(i) == '-') {
				num2 = chars.pop();
				num1 = chars.pop();
				result = num1 - num2;
				chars.push(result);
			} else if(str.charAt(i) == '/') {
				num2 = chars.pop();
				num1 = chars.pop();
				result = num1 / num2;
				chars.push(result);
			} else if(str.charAt(i) == '*') {
				num2 = chars.pop();
				num1 = chars.pop();
				result = num1 * num2;
				chars.push(result);
			}
		}
		System.out.printf("%.2f", result);
	}
}
