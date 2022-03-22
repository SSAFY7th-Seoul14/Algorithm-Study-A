package jhkim.p220322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1504 {

    static int N, matrix[][];
    static int[] distance;
    static boolean[] visited;

    public static int dijkstra(int start, int end) {
        Arrays.fill(distance, 200000001);
        Arrays.fill(visited, false);

        distance[start] = 0;

        for (int i = 0; i < N; i++) {
            int min = 200000001, current = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if (current == end) break;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && matrix[current][j] != 0 && distance[j] > distance[current] + matrix[current][j]) {
                    distance[j] = distance[current] + matrix[current][j];
                }
            }
        }
        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        int from, to, dist;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            dist = Integer.parseInt(st.nextToken());
            matrix[from][to] = dist;
            matrix[to][from] = dist;
        }

        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken()) - 1;
        int must2 = Integer.parseInt(st.nextToken()) - 1;

        int min1 = 0;
        int min2 = 0;

        distance = new int[N];
        visited = new boolean[N];

        //1 - 1. 1-must1 Dijkstra
        min1 += dijkstra(0, must1);
        if (min1 > 200000000) min1 = -1;
        else {
            //1 - 2. must1-must2 Dijkstra
            min1 += dijkstra(must1, must2);
            if (min1 > 200000000) min1 = -1;
            else {
                min1 += dijkstra(must2, N - 1);
                if (min1 > 200000000) min1 = -1;
            }
        }

        //1 - 1. 1-must1 Dijkstra
        min2 += dijkstra(0, must2);
        if (min2 > 200000000) min2 = -1;
        else {
            //1 - 2. must1-must2 Dijkstra
            min2 += dijkstra(must2, must1);
            if (min2 > 200000000) min2 = -1;
            else {
                min2 += dijkstra(must1, N - 1);
                if (min2 > 200000000) min2 = -1;
            }
        }

        if (min1 == -1 || min2 == -1)
            if (min1 > min2) {
                System.out.println(min1);
            }
            else {
                System.out.println(min2);
            }
        else {
            System.out.println(Math.min(min1, min2));
        }

    }
}
