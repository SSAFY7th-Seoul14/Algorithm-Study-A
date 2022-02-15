import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int P , L, V, idx =1;
        StringBuilder sb =new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if(L==0) break;

            int answer =0;
            answer= V/P *L;

            if(V%P <= L) answer+= V%P;
            else answer +=L;

            sb.append("Case ").append(idx++).append(": ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
