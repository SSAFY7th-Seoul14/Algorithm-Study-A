import java.util.Scanner;
import java.util.Stack;

public class BOJ_1725 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] number = new int[n];
        for(int i=0;i<n;i++) number[i]=sc.nextInt();
        Stack<Integer> stack=new Stack();
        int answer=0;
        for(int i=0;i<n;i++){
            int right=i-1;
            while((!stack.isEmpty())&&number[stack.peek()]>number[i]){
                int height=number[stack.pop()];
                int left =(stack.isEmpty())?0:stack.peek()+1;
                answer=Math.max(answer,height*(right-left+1));
            }
            stack.push(i);
        }
        int right=n-1;
        while(!stack.isEmpty()){
            int height=number[stack.pop()];
            int left=(stack.isEmpty())?0:stack.peek()+1;
            answer=Math.max(answer,height*(right-left+1));
        }
        System.out.println(answer);



    }
}
