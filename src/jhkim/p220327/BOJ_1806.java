package jhkim.p220327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

    static int N, S, nums[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        long total = 0;
        boolean first = false;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            total += nums[i];
        }

        if (total < S) {
            System.out.println("0");
        } else {
            System.out.println(check());
        }
    }

    private static int check() {

        int result = 100001;

        int from = 0;
        int to = 0;

        int sum = 0;

        while (true) {
            if (sum >= S) {
                sum -= nums[from];
                if (result > to - from) {
                    result = to - from;
                }
                from++;
            } else if (to >= N) {
                break;
            } else {
                sum += nums[to];
                to++;
            }
        }
        return result;
    }
}
