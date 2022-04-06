package jhkim.p220406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17471 {

    static int N, cities[], map[][], parents[], result = Integer.MAX_VALUE, diff, cnt, zero, total;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> groupA = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> groupB = new ArrayList<>();
    static boolean[] nums;
    static ArrayList<Integer> curr1, curr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cities = new int[N];
        map = new int[N][N];
        int link, to;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            link = Integer.parseInt(st.nextToken());
            if (link == 0) {
                cnt++;
                zero = i;
            }
            for (int j = 0; j < link; j++) {
                to = Integer.parseInt(st.nextToken()) - 1;
                map[i][to] = map[to][i] = 1;
            }
        }
        nums = new boolean[N];

        if(N == 2) {
            result = Math.abs(cities[0] - cities[1]);
        } else if (cnt > 1 && N > 2) {
            result = -1;
        } else {
            for (int i = 1; i <= N / 2; i++) {
                com(0, 0, i);
            }

            for (int i = 0; i < groupA.size(); i++) {
                diff = bfs(groupA.get(i), groupB.get(i));
                result = Math.min(result, diff);
            }

            if(result > 1000) result = -1;

        }
        System.out.println(result);
    }

    private static void com(int start, int count, int end) {
        if (count == end) {
            curr1 = new ArrayList<>();
            curr2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (nums[i]) {
                    curr1.add(i);
                } else {
                    curr2.add(i);
                }
            }
            groupA.add(curr1);
            groupB.add(curr2);
            return;
        }
        for (int i = start; i < N; i++) {
            nums[i] = true;
            com(i + 1, count + 1, end);
            nums[i] = false;
        }
    }

    private static int bfs(ArrayList<Integer> a, ArrayList<Integer> b) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(a.get(0));
        boolean visited[] = new boolean[N];
        visited[a.get(0)] = true;
        int curr, to;
        int atotal = 0, btotal = 0;

        while (!q.isEmpty()) {
            curr = q.poll();
            for (int i = 0; i < a.size(); i++) {
                to = a.get(i);
                if (map[curr][to] == 1 && !visited[to]) {
                    q.offer(to);
                    visited[to] = true;
                }
            }
        }
        q.clear();

        q.offer(b.get(0));
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int i = 0; i < b.size(); i++) {
                to = b.get(i);
                if (map[curr][to] == 1 && !visited[to]) {
                    q.offer(to);
                    visited[to] = true;
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (!visited[a.get(i)]) return Integer.MAX_VALUE;
            atotal += cities[a.get(i)];
        }

        for (int i = 0; i < b.size(); i++) {
            if (!visited[b.get(i)]) return Integer.MAX_VALUE;
            btotal += cities[b.get(i)];
        }

        return Math.abs(atotal - btotal);
    }
}
