package BOJ0214;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] number = new int[n];
        Stack<Integer> stack = new Stack();
        number[0]=sc.nextInt();
        stack.add(number[0]);
        for(int i=1;i<n;i++){
            number[i]=sc.nextInt();
            if(stack.peek()>0) stack.add(stack.peek()+number[i]);
            else stack.add(number[i]);
        }
        System.out.println(Collections.max(stack));


    }
}
