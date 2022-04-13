package jhkim.p220330;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_Kruskal {

    static class Node implements Comparable<Node> {

        int from;
        int to;
        int dis;

        public Node(int from, int to, int dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dis > o.dis) return 1;
            if(this.dis == o.dis) return 0;
            else return -1;
        }
    }

    static int T, V, E, A, B, C, count;
    static int parents[];
    static Node[] nodeList;
    static long result;

    public static void makeSet() {
        parents = new int[V];
        for(int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            nodeList = new Node[E];
            result = 0;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken()) - 1;
                B = Integer.parseInt(st.nextToken()) - 1;
                C = Integer.parseInt(st.nextToken());

                nodeList[i] = new Node(A, B, C);
            }

            Arrays.sort(nodeList);
            makeSet();

            count = 0;

            for (Node n: nodeList) {
                if(union(n.from, n.to)) {
                    result += n.dis;
                    if(++count == V - 1) break;
                }
            }
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
