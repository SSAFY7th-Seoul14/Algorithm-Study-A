import java.io.*;
import java.util.*;

public class Boj_6603 {
    static int R=6,N;
    static int [] arr, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0)
                break;
            arr = new int[N];
            result=new int[R];
            for(int idx=0;st.hasMoreTokens(); idx++){
                arr[idx]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            combi(0,0);
            System.out.println();


        }
    }
    static void combi(int cnt,int start){
        if(cnt == R){
            StringBuilder sb = new StringBuilder();
           for(int i=0; i<R-1; i++){
               sb.append(result[i]+" ");
           }
           sb.append(result[R-1]);
           System.out.println(sb.toString());
           return;

        }else{
            for(int i=start; i<N; i++){
                result[cnt]=arr[i];
                combi(cnt+1,i+1);
            }
        }

    }
}
