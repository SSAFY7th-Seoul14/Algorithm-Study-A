package BOJ0221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {
    static int n;
    static int[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}, dy = {-2, -1, 1, 2, -2, -1, 1, 2};


    static int sol(int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1]=1;
        int t = 0;
        while (!q.isEmpty()) {
            int a=q.size();
            for (int b = 0; b < a; b++) {
                int[] temp = q.poll();
                int x = temp[0], y = temp[1];
                if (x == x2 && y == y2) return t;
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            t += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            visited = new int[n][n];
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            System.out.println(sol(a,b,c,d));

        }
    }
}
