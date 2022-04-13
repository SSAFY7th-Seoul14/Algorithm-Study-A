package jhkim.p220406;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5643 {
    static int N, M, result;
    static Student[] students;

    static class Student {
        ArrayList<Integer> taller;
        ArrayList<Integer> smaller;

        public Student(ArrayList<Integer> taller, ArrayList<Integer> smaller) {
            this.taller = taller;
            this.smaller = smaller;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int a, b;

        for (int tc = 1; tc <= T; tc++) {
            result = 0;

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            students = new Student[N];
            for (int i = 0; i < N; i++) {
                students[i] = new Student(new ArrayList<>(), new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;
                students[a].smaller.add(b);
                students[b].taller.add(a);
            }

            union();

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union() {
        int update, value;
        int cnt1, cnt2;
        for (int i = 0; i < N; i++) {
            while (true) {
                cnt1 = 0;
                cnt2 = 0;
                for (int j = 0; j < students[i].taller.size(); j++) {
                    update = students[i].taller.get(j);
                    for (int k = 0; k < students[update].taller.size(); k++) {
                        value = students[update].taller.get(k);
                        if (!students[i].taller.contains(value)) {
                            students[i].taller.add(value);
                            cnt1++;
                        }
                    }
                }
                for (int j = 0; j < students[i].smaller.size(); j++) {
                    update = students[i].smaller.get(j);
                    for (int k = 0; k < students[update].smaller.size(); k++) {
                        value = students[update].smaller.get(k);
                        if (!students[i].smaller.contains(value)) {
                            students[i].smaller.add(value);
                            cnt2++;
                        }
                    }
                }
                if (cnt1 == 0 && cnt2 == 0) {
                    if (students[i].taller.size() + students[i].smaller.size() == N - 1) result++;
                    break;
                }
            }

        }

    }

}
