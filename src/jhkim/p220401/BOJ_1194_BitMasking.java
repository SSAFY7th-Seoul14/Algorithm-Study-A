package jhkim.p220401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_BitMasking {

    static char[][] maze;
    static int N, M, startX, startY, nx, ny;
    static int key, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][] visited;

    static class Minsik {
        int x, y, count, key;

        public Minsik(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Byte.parseByte(st.nextToken());
        M = Byte.parseByte(st.nextToken());

        maze = new char[N][M];

        String line;

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited = new boolean[N][M][64];

        System.out.println(gotoMoon());
    }

    private static int gotoMoon() {

        Queue<Minsik> q = new LinkedList<>();

        Minsik cur;
        q.offer(new Minsik(startX, startY, 0, 0));
        visited[startX][startY][0] = true;

        while (!q.isEmpty()) {

            cur = q.poll();
            key = cur.key;
            count = cur.count;
            if (maze[cur.x][cur.y] == '1') {
                return cur.count;
            }
            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (!available(nx, ny, key)) continue;
                if (maze[nx][ny] == '#' || visited[nx][ny][key]) continue;
                if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    int newKey = 1 << (maze[nx][ny] - 'a');
                    newKey = newKey | key;
                    if (!visited[nx][ny][newKey]) {
                        visited[nx][ny][key] = true;
                        visited[nx][ny][newKey] = true;
                        q.offer(new Minsik(nx, ny, count + 1, newKey));
                    }
                } else if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F') {
                    int door = 1 << (maze[nx][ny] - 'A');
                    if ((key & door) > 0) {
                        visited[nx][ny][key] = true;
                        q.offer(new Minsik(nx, ny, count + 1, key));
                    }
                } else {
                    visited[nx][ny][key] = true;
                    q.offer(new Minsik(nx, ny, count + 1, key));
                }
            }
        }
        return -1;
    }

    public static boolean available(int x, int y, int key) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        return true;
    }
}
