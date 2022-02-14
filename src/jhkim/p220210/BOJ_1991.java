package jhkim.p220210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1991 {

	static class Node {
		int index;
		Node parent;
		Node left;
		Node right;

		public Node(int index) {
			this.index = index;
		}
	}

	static int n;
	static Node[] tree;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String alphabets;
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		tree = new Node[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new Node(i);
		}
		for (int i = 0; i < n; i++) {
			alphabets = br.readLine();
			st = new StringTokenizer(alphabets);

			int node = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';

			if (left >= 0 && left <= 26) {
				tree[node].left = tree[left];
				tree[left].parent = tree[node];
			}
			if (right >= 0 && right <= 26) {
				tree[node].right = tree[right];
				tree[right].parent = tree[node];
			}
		}
		preOrder(0);
		bw.newLine();
		inOrder(0);
		bw.newLine();
		postOrder(0);
		bw.flush();
		br.close();
		bw.close();

	}

	public static void preOrder(int now) throws IOException {
		bw.write((char) (tree[now].index + 'A'));
		if (tree[now].left != null) {
			preOrder(tree[now].left.index);
		}
		if (tree[now].right != null) {
			preOrder(tree[now].right.index);
		}
	}

	public static void inOrder(int now) throws IOException {
		if (tree[now].left != null) {
			inOrder(tree[now].left.index);
		}
		bw.write((char) (tree[now].index + 'A'));
		if (tree[now].right != null) {
			inOrder(tree[now].right.index);
		}
	}

	public static void postOrder(int now) throws IOException {
		if (tree[now].left != null) {
			postOrder(tree[now].left.index);
		}
		if (tree[now].right != null) {
			postOrder(tree[now].right.index);
		}
		bw.write((char) (tree[now].index + 'A'));
	}
}
