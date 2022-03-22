package jhkim.p220323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17140 {

    static int r, c, k, array[][] = new int[100][100], row, col, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        row = 3;
        col = 3;
        time = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (array[r][c] == k) break;
            if (time > 100) {
                time = -1;
                break;
            }
            if (row >= col) {
                r();
            } else {
                c();
            }
            time++;
        }
        System.out.println(time);
    }

    private static void r() {
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> rows = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                int v = array[i][j];
                if (v != 0) {
                    rows.add(v);
                }
            }
            sorting(rows, i, "row");
        }
    }

    private static void c() {
        for (int i = 0; i < col; i++) {
            ArrayList<Integer> cols = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                int v = array[j][i];
                if (v != 0) {
                    cols.add(v);
                }
            }
            sorting(cols, i, "col");
        }
    }

    static class Num implements Comparable<Num> {
        int idx, count;

        public Num(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Num n) {
            return this.count - n.count == 0 ? this.idx - n.idx : this.count - n.count;
        }
    }

    private static void sorting(ArrayList<Integer> list, int nth, String which) {
        Num[] nums = new Num[101];

        for (int i = 0; i < 101; i++) {
            nums[i] = new Num(i, 0);
        }

        for (int i = 0; i < list.size(); i++) {
            nums[list.get(i)].count++;
        }

        Arrays.sort(nums);

        Queue<Integer> res = new LinkedList<>();

        for (int i = 0; i < 101; i++) {
            if (nums[i].count != 0) {
                res.offer(nums[i].idx);
                res.offer(nums[i].count);
            }
        }

        if (which.equals("row")) {
            for (int i = 0; i < 100 ; i++) {
                array[nth][i] = 0;
            }
        } else {
            for (int i = 0; i < 100; i++) {
                array[i][nth] = 0;
            }
        }

        if (which.equals("row")) {
            col = Math.max(col, res.size());
            if(col > 100) col = 100;
            for (int i = 0; i < col; i++) {
                array[nth][i] = res.poll();
                if(res.isEmpty()) break;
            }
        } else {
            row = Math.max(row, res.size());
            if(row > 100) row = 100;
            for (int i = 0; i < row; i++) {
                array[i][nth] = res.poll();
                if(res.isEmpty()) break;
            }
        }
    }
}
