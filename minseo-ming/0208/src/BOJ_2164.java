import java.util.*;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=num; i++) queue.add(i);
        while (true){
            if(queue.size()==1){
                System.out.println(queue.poll());
                return;
            }
            queue.poll();
            queue.offer(queue.poll());
        }
    }
}
