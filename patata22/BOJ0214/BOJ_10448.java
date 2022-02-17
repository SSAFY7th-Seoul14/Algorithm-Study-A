package BOJ0214;

import java.util.Scanner;

public class BOJ_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[44];
        for(int i=0;i<44;i++) number[i]=(i+1)*(i+2)/2;
        int T= sc.nextInt();
        for(int t=0;t<T;t++){
            int answer=0, temp = sc.nextInt();
            for(int i=0;i<44;i++){
                for(int j=i;j<44;j++){
                    for(int k=j;k<44;k++){
                        if(number[i]+number[j]+number[k]==temp){
                            answer=1;
                            break;
                        }
                    }
                }
            }
            System.out.println(answer);
        }


    }
}
