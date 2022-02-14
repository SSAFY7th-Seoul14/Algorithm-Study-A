import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //TC 입력
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), idx = sc.nextInt(), answer = 0;
            Queue<Integer> q = new LinkedList<>(); // 우선순위가 들어감
            Queue<Integer> q2 = new LinkedList<>(); // 인덱스가 들어감
            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt()); //큐에 우선순위 저장
                q2.add(i); //큐2에 인덱스 저장
            }
            while (!q.isEmpty()) {
                if (q.peek() == Collections.max(q)) {
                    answer += 1;
                    if (q2.peek() == idx) break;
                    else {
                        q.poll();
                        q2.poll();
                    }

                } else { //최대값이 아니면 맨앞 요소들을 다시 맨 뒤로
                    q.add(q.poll());
                    q2.add(q2.poll());
                }
            }
            System.out.println(answer);
        }
    }
}
