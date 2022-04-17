package jhkim.p220413;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17143 {

    static int R, C, M, ocean[][], result;
    static ArrayList<Shark> sharks;
    static int dx[] = {-1, 1};
    static int dy[] = {-1, 1};

    static class Shark implements Comparable<Shark> {
        int r, c, d, s, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.r == o.r) {
                if (this.c == o.c) {
                    return this.z - o.z;
                }
                return this.c - o.c;
            }
            return this.r - o.r;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new int[R][C];
        sharks = new ArrayList<>();
        result = 0;

        int r, c, s, d, z;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            sharks.add(new Shark(r, c, s, d, z));
        }
        br.close();

        fishing();

        System.out.println(result);
    }

    private static void fishing() {
        for (int i = 0; i < C; i++) {

            Shark catched = null;
            int idx = 0;
            for (int j = 0; j < sharks.size(); j++) {
                if (sharks.get(j).c == i) {
                    if (catched == null) {
                        catched = sharks.get(j);
                        idx = j;
                    } else if (catched.r > sharks.get(j).r) {
                        catched = sharks.get(j);
                        idx = j;
                    }
                }
            }

            if (catched != null) {
                result += catched.z;
                sharks.remove(idx);
            }
            moveShark();
        }
    }

    private static void moveShark() {
        for (int i = 0; i < sharks.size(); i++) {
            Shark cur = sharks.get(i);

            int idx;
            if (cur.d == 1) {
                idx = 0;
                for (int j = 0; j < cur.s; j++) {
                    if (cur.r == 0) {
                        cur.d = 2;
                        idx = 1;
                    } else if (cur.r == R - 1) {
                        cur.d = 1;
                        idx = 0;
                    }
                    cur.r += dx[idx];
                }
            } else if (cur.d == 2) {
                idx = 1;
                for (int j = 0; j < cur.s; j++) {
                    if (cur.r == 0) {
                        cur.d = 2;
                        idx = 1;
                    } else if (cur.r == R - 1) {
                        cur.d = 1;
                        idx = 0;
                    }
                    cur.r += dx[idx];
                }

            } else if (cur.d == 3) {
                idx = 1;
                for (int j = 0; j < cur.s; j++) {
                    if (cur.c == 0) {
                        cur.d = 3;
                        idx = 1;
                    } else if (cur.c == C - 1) {
                        cur.d = 4;
                        idx = 0;
                    }
                    cur.c += dy[idx];
                }
            } else {
                idx = 0;
                for (int j = 0; j < cur.s; j++) {
                    if (cur.c == 0) {
                        cur.d = 3;
                        idx = 1;
                    } else if (cur.c == C - 1) {
                        cur.d = 4;
                        idx = 0;
                    }
                    cur.c += dy[idx];
                }
            }
        }

        Collections.sort(sharks);
        if(!sharks.isEmpty()){
            Shark std = sharks.get(0);
            for (int i = 1; i < sharks.size(); i++) {
                if (std.r != sharks.get(i).r) {
                    std = sharks.get(i);
                    continue;
                }
                if (std.c != sharks.get(i).c) {
                    std = sharks.get(i);
                    continue;
                }
                std = sharks.get(i);
                sharks.remove(--i);
            }
        }
    }
}
