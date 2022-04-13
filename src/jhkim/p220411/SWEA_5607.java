package jhkim.p220411;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5607 {

    static int modN = 1234567891, N, R;
    static long fac[], result;

    private static void factorial(int n) {
        fac[1] = 1;
        for (int i = 2; i <= n; i++) {
            fac[i] = i * fac[i - 1] % modN;
        }
    }

    private static long fermat(long a, int b) {

        if (b == 0) return 1;
        else if (b == 1) return a;
        if (b % 2 == 0) {
            long temp = fermat(a, b / 2);
            return (temp * temp) % modN;
        } else {
            long temp = fermat(a, b - 1) % modN;
            return (temp * a) % modN;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            fac = new long[N + 1];
            factorial(N);

            result = (fac[N] * fermat((fac[R] * fac[N - R]) % modN, modN - 2)) % modN;

            bw.write("#" + tc + " " + result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
