import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[num][2];

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] =Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]) !=0 ? Integer.compare(o1[1],o2[1]): Integer.compare(o1[0],o2[0]);
            }
        });
        int count =1;
        int end = arr[0][1];
        for(int i =1; i<num; i++){
            if(end<=arr[i][0]){
                count++;
                end = arr[i][1];
            }
        }
        System.out.println(count);
    }
}
