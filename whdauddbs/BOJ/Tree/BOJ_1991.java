import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1991 {
	static Map<Character, char[]> tree = new HashMap<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			tree.put(input[0], new char[] {input[0], input[2], input[4]});
		}
		
		sb = new StringBuilder();
		preorder(tree.get('A'));
		System.out.println(sb.toString());
		sb = new StringBuilder();
		inorder(tree.get('A'));
		System.out.println(sb.toString());
		sb = new StringBuilder();
		postorder(tree.get('A'));
		System.out.println(sb.toString());

		br.close();
	}
	
	static void preorder(char[] node) {
		sb.append(node[0]);
		if(node[1] != '.') preorder(tree.get(node[1]));
		if(node[2] != '.') preorder(tree.get(node[2]));
	}
	
	static void inorder(char[] node) {
		if(node[1] != '.') inorder(tree.get(node[1]));
		sb.append(node[0]);
		if(node[2] != '.') inorder(tree.get(node[2]));
	}
	
	static void postorder(char[] node) {
		if(node[1] != '.') postorder(tree.get(node[1]));
		if(node[2] != '.') postorder(tree.get(node[2]));
		sb.append(node[0]);
	}
}
