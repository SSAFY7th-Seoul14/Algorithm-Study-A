import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_1913_3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int find = sc.nextInt();

        int arr[][] = new int[N][N];
        int x=0,y=0, result_x=0,result_y=0,data = N*N,limit=N,time=0;
        while(data>0){
            y=time;
            for(int i=x; i<limit; i++){
                arr[i][y]=data--;
            }
            x=limit-1;
            for(int i=y+1;i<limit; i++){
                arr[x][i]=data--;
            }
            y=limit-1;
            for(int i=x-1; i>=time; i--){
                arr[i][y]=data--;
            }
            x=time;
            for(int i=y-1;i>time; i--){
                arr[x][i]=data--;
            }
            time++;
            limit--;
            x=time;
        }


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for(int j =0; j<N; j++){
                if(arr[i][j]==find){
                    result_x=i+1;
                    result_y=j+1;
                }
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.write(result_x+" "+result_y);
        bw.flush();
        bw.close();
    }
}
