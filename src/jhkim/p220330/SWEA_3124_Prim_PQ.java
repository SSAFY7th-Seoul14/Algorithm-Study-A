package jhkim.p220330;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_Prim_PQ {

    static class Node implements Comparable<Node> {

        int val;
        long dis;

        public Node(int val, long dis) {
            this.val = val;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dis > o.dis) return 1;
            if(this.dis == o.dis) return 0;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Node> pq;
        ArrayList<ArrayList<Node>> list;
        int T = Integer.parseInt(br.readLine());
        int V, E, A, B, C;
        boolean[] visited;
        long result;
        int count;

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            pq = new PriorityQueue<>();
            list = new ArrayList<>();
            visited = new boolean[V];

            count = 0;
            result = 0;

            for(int i = 0; i < V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken()) - 1;
                B = Integer.parseInt(st.nextToken()) - 1;
                C = Integer.parseInt(st.nextToken());

                list.get(A).add(new Node(B, C));
                list.get(B).add(new Node(A, C));
            }
            pq.add(new Node(0, 0));

            while(!pq.isEmpty()) {
                Node n = pq.poll();

                if(visited[n.val]) continue;
                visited[n.val] = true;

                result += n.dis;

                for (Node no : list.get(n.val)) {
                    if(!visited[no.val]) {
                        pq.add(no);
                    }
                }
                if(++count == V) break;
            }
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
