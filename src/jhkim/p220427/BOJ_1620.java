package jhkim.p220427;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numMap = new HashMap<>();
        HashMap<String, Integer> strMap = new HashMap<>();

        String name;
        for(int i = 1; i <= N; i++) {
            name = br.readLine();
            numMap.put(i, name);
            strMap.put(name, i);
        }

        for(int i = 0; i < M; i++) {
            name = br.readLine();
            try {
                int n = Integer.parseInt(name);
                bw.write(numMap.get(n) + "\n");
            } catch (NumberFormatException e) {
                bw.write(strMap.get(name) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
