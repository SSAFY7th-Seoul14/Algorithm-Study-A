package jhkim.p220404;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int result = 0;
        int N, array[], len[];

        for(int tc = 1; tc <= T; tc++) {

            result = 0;
            N = Integer.parseInt(br.readLine());
            array = new int[N];
            len = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < N; i++) {
                if(i == 0) {
                    len[i] = 1;
                } else {
                    for(int j = 0; j < i; j++) {
                        if(array[j] < array[i]) {
                            len[i] = Math.max(len[j] + 1, len[i]);
                            result = Math.max(len[i], result);
                        } else {
                            len[i] = Math.max(len[i], 1);
                        }
                    }
                }
            }
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
