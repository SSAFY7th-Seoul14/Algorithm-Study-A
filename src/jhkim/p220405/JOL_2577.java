package jhkim.p220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] sushies = new int[N];
        for (int i = 0; i < N; i++) {
            sushies[i] = Integer.parseInt(br.readLine());
        }

        int start = 0, cnt = 0;

        int[] edible = new int[3001];

        for (int i = start; i < start + k; i++) {
            if (++edible[sushies[i]] == 1) {
                cnt++;
            }
        }
        ans = cnt;

        while (true) {
            if (start == N - 1) break;
            if (start + k >= N) {
                if (++edible[sushies[start + k - N]] == 1) cnt++;
                if (--edible[sushies[start]] == 0) cnt--;
                if (edible[c] == 0) {
                    cnt++;
                    ans = Math.max(cnt, ans);
                    cnt--;
                } else {
                    ans = Math.max(cnt, ans);
                }
            } else {
                if (++edible[sushies[start + k]] == 1) cnt++;
                if (--edible[sushies[start]] == 0) cnt--;
                if (edible[c] == 0) {
                    cnt++;
                    ans = Math.max(cnt, ans);
                    cnt--;
                } else {
                    ans = Math.max(cnt, ans);
                }
            }
            start++;
        }
        System.out.println(ans);
    }
}
