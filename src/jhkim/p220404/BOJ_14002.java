package jhkim.p220404;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14002 {
    static class longestSubArray {
        int len;
        ArrayList<Integer> sub = new ArrayList<>();

        public longestSubArray(int len, ArrayList<Integer> sub) {
            this.len = len;
            this.sub = sub;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int res = 1, temp = -1, ans = 0;

        int[] org = new int[N];
        longestSubArray[] lis = new longestSubArray[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            org[i] = Integer.parseInt(st.nextToken());
            lis[i] = new longestSubArray(1, new ArrayList<>());
        }

        lis[0].sub.add(org[0]);

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(org[i] > org[j]) {
                    if(lis[j].len + 1 > lis[i].len) {
                        lis[i].len = lis[j].len + 1;
                        temp = j;
                    }
                }
            }
            if(temp != -1) {
                for(int j = 0; j < lis[temp].sub.size(); j++) {
                    lis[i].sub.add(lis[temp].sub.get(j));
                }
                temp = -1;
            }
            lis[i].sub.add(org[i]);
            if(res < lis[i].len) {
                res = lis[i].len;
                ans = i;
            }
        }

        bw.write(res + "\n");
        for(int i = 0; i < res; i++) {
            bw.write(lis[ans].sub.get(i) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
