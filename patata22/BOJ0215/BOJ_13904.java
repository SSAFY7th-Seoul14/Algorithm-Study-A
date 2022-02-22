package BOJ0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        Homework[] total = new Homework[n];
        for(int i=0;i<n;i++){
            String[] temp = br.readLine().split(" ");
            total[i] = new Homework(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
        }
        Arrays.sort(total, new Comparator<Homework>() {
            @Override
            public int compare(Homework o1, Homework o2) {
                int temp = o2.score-o1.score;
                if(temp==0) temp = o1.end-o2.end;
                return temp;
            }
        });

        int answer=0;
        boolean[] used = new boolean[n];
        for(int j=1000;j>0;j--){
            for(int i=0;i<n;i++){
                if(total[i].end>=j&&!used[i]){
                    used[i]=true;
                    answer+=total[i].score;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
class Homework{
    int end, score;
    public Homework(int end, int score){
        this.end=end;
        this.score=score;
    }
}
