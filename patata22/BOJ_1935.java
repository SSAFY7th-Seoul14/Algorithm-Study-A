import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1935 {
    static String temp = "+-*/";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,Integer> map = new HashMap();
        int n=Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split("");
        double answer=0;
        for(int i=0;i<n;i++){
            map.put((char)(65+i),sc.nextInt());
        }

        Stack<Double> stack= new Stack();
        for(String x: s){
            if(!temp.contains(x)){
                stack.push((double)map.get(x.charAt(0)));
            }
            else{
                Double b=stack.pop();
                Double a=stack.pop();
                if(x.equals("+")) stack.push(a+b);
                else if(x.equals("-")) stack.push(a-b);
                else if(x.equals("*")) stack.push(a*b);
                else if(x.equals("/")) stack.push(a/b);
            }
        }
        System.out.printf("%.2f%n",stack.pop());








    }

}
