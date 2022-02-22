package BOJ0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11728 { //S5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n= Integer.parseInt(temp[0]), m = Integer.parseInt(temp[1]);
        StringBuilder answer= new StringBuilder();
        String[] temp1 = br.readLine().split(" ");
        String[] temp2= br.readLine().split(" ");
        int N=0, M=0;
        while(N<n&&M<m){
            if(Integer.parseInt(temp1[N])<=Integer.parseInt(temp2[M])) answer.append(temp1[N++]+" ");
            else answer.append(temp2[M++]+" ");
        }
        for(int i=N;i<n;i++) answer.append(temp1[i]+" ");
        for(int i=M;i<m;i++) answer.append(temp2[i]+" ");
        System.out.println(answer);











    }
}
