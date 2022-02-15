import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11728 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int num: list ) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
