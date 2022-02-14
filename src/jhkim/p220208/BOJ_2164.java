package jhkim.p220208;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Queue<Integer> cards = new ArrayDeque<Integer>();
		int card;

		if (n == 1) {
			System.out.println(1);
		} else {

			for (int i = 1; i <= n; i++) {
				cards.offer(i);
			}

			while (true) {
				cards.poll();
				if (cards.size() == 1)
					break;
				cards.offer(cards.poll());
			}
			System.out.println(cards.poll());
		}
	}
}
