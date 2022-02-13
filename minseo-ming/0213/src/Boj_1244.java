import java.io.*;
import java.util.*;

public class Boj_1244 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int bulb []= new int[num];

        for(int i=0; st.hasMoreTokens();i++){
            bulb[i]=Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());

        for(int i=0; i<student; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int r = idx, l = idx-2;

            if(sex==2) {
                if (bulb[idx-1] == 0) bulb[idx-1] = 1;
                else bulb[idx-1] = 0;
                while (r < num && l >= 0 && bulb[r] == bulb[l]) {
                    if(bulb[r]==0){
                        bulb[r]=1;
                        bulb[l]=1;
                    }
                    else{
                        bulb[r]=0;
                        bulb[l]=0;
                    }
                    r++;
                    l--;
                }
            }else{
                for(int j = 1; j<=num; j++){
                    if(j%idx==0) {
                        if (bulb[j-1] == 0) bulb[j-1] = 1;
                        else bulb[j-1] = 0;
                    }
                }
            }

        }

        int cnt=0;
        for (int i = 0; i < bulb.length; i++) {
            if(cnt>0&&cnt%20==0) System.out.println();
            System.out.print(bulb[i]+" ");
            cnt++;
        }
    }
}
