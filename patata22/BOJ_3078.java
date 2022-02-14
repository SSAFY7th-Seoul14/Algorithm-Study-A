import java.util.*;

public class BOJ_3078 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long n=sc.nextInt(), k=sc.nextInt(), answer=0;
        int[] score=new int[21];
        Queue<String> q = new LinkedList<>();
        while(q.size()<k+1){
            String temp=sc.next();
            answer+=score[temp.length()];
            score[temp.length()]+=1;
            q.add(temp);

        }
        for(int i=0;i<n-k-1;i++){
            String temp1=q.poll();
            score[temp1.length()]-=1;
            String temp2=sc.next();
            answer+=score[temp2.length()];
            score[temp2.length()]+=1;
            q.add(temp2);
        }
        System.out.println(answer);
    }
}
