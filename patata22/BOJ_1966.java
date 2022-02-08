import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), idx = sc.nextInt(), answer = 0;
            Queue<Integer> q = new LinkedList<>(); // 우선순위가 들어감
            Queue<Integer> q2 = new LinkedList<>(); // 인덱스가 들어감
            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt());
                q2.add(i);
            }
            while (!q.isEmpty()) {
                if (q.peek() == Collections.max(q)) {
                    answer += 1;
                    if (q2.peek() == idx) break;
                    else {
                        q.poll();
                        q2.poll();
                    }

                } else {
                    q.add(q.poll());
                    q2.add(q2.poll());
                }
            }
            System.out.println(answer);

        }
    }
}
