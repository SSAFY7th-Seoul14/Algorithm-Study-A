package jhkim.p220404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int array[] = new int[N];
        int[] lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        lis[0] = array[0];
        if (N > 1) {
            for (int i = 1; i < N; i++) {
                lis[i] = array[i];
                for (int j = 0; j < i; j++) {
                    if (array[i] > array[j]) {
                        if (lis[j] + array[i] > lis[i]) {
                            lis[i] = lis[j] + array[i];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            res = Math.max(res, lis[i]);
        }
        System.out.println(res);
    }
}
