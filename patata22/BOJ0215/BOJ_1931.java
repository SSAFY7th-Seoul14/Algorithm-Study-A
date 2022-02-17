package BOJ0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1931 { //S2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine()),answer=0;
        task[] total = new task[n];
        for(int i=0;i<n;i++){
            String[] temp = br.readLine().split(" ");
            total[i] = new task(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
        }
        Arrays.sort(total, new Comparator<task>() {
            @Override
            public int compare(task o1, task o2) {
                int temp= o1.end-o2.end;
                if(temp==0) temp = o1.start-o1.end;
                return temp;
            }
        });
        int now=0;
        for(task x: total){
            if(x.start<now)continue;
            else{
                answer+=1;
                now=x.end;
            }
        }
        System.out.println(answer);
    }
}

class task{
    int start;
    int end;
    public task(int start, int end){
        this.start=start;
        this.end=end;
    }
}