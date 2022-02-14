import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int len = Integer.parseInt(br.readLine());
        int []input = new int[len];
        int [] temp = new int[len];
        int max;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            input[i] =Integer.parseInt(st.nextToken());
        }
        br.close();

        temp[0] =input[0];
        max = temp[0];
        for(int i=1; i<len; i++){
            temp[i] =Math.max(temp[i-1]+input[i],input[i]);
            max = Math.max(max,temp[i]);
        }

        System.out.println(max);
    }

}

