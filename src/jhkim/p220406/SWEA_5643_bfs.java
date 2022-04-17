package jhkim.p220406;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_bfs {
    static int N, M, result;
    static Student[] students;
    static boolean[] visited;

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

            for (int i = 0; i < N; i++) {
                union(i);
            }

            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int curr, val;
        visited = new boolean[N];
        visited[start] = true;

        while(!q.isEmpty()) {
            curr = q.poll();

            for(int i = 0; i < students[curr].taller.size(); i++) {
                val = students[curr].taller.get(i);
                if(visited[val]) continue;
                if(!students[start].taller.contains(val)) {
                    students[start].taller.add(val);
                }
                q.offer(val);
                visited[val] = true;
            }
        }

        q.clear();
        q.offer(start);
        visited = new boolean[N];
        visited[start] = true;

        while(!q.isEmpty()) {
            curr = q.poll();

            for(int i = 0; i < students[curr].smaller.size(); i++) {
                val = students[curr].smaller.get(i);
                if(visited[val]) continue;
                if(!students[start].smaller.contains(val)) {
                    students[start].smaller.add(val);
                }
                q.offer(val);
                visited[val] = true;
            }
        }

        if(students[start].taller.size() + students[start].smaller.size() == N - 1) result++;

    }
}
