import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        //모듈려 연산성질...
        //(a*b)mod c == (a%c *b%c) %c
        System.out.println(repeat(num%div,power,div));
    }

    static long repeat (int num, int power,int div){
        if(power ==1)return(long) num;
        long temp = repeat(num,power/2,div)%div;
        return power%2==0? (temp*temp)%div:((temp*temp%div)*num)%div ;

    }
    //(temp * temp * num) %div == ((temp*temp%div)*(num%div) %div
    //                          ==(((temp*temp%div)%div) *(num%div))%div
    //                              ((temp*temp%div)*num)%div
}
