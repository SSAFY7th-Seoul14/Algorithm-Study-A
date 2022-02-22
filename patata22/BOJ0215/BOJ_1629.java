package BOJ0215;

import java.util.Scanner;

public class BOJ_1629 { //S1
    static long sol(int a , int b, int c){
        if(b==0) return 1;
        else if(b==1) return a%c;
        else{
            long temp=sol(a,b/2,c)%c;
            if(b%2==0) return (temp*temp)%c;
            else return a*(temp*temp%c)%c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sol(sc.nextInt(),sc.nextInt(),sc.nextInt()));

    }
}
