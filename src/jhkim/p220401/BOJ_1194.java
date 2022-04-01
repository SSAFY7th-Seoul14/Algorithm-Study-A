package jhkim.p220401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {

    static char[][] maze;
    static byte N, M, startX, startY, nx, ny, keyT, newKeyT;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][] visited;

    static class Minsik {
        byte x, y;
        int count;
        byte[] keys;

        public Minsik(byte x, byte y, int count, byte[] keys) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.keys = keys;
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
                    startX = (byte) i;
                    startY = (byte) j;
                }
            }
        }

        visited = new boolean[N][M][64];

        gotoMoon();

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    private static void gotoMoon() {

        Queue<Minsik> q = new LinkedList<>();

        Minsik cur;
        q.offer(new Minsik(startX, startY, 0, new byte[6]));

        while (!q.isEmpty()) {

            cur = q.poll();
            if (maze[cur.x][cur.y] == '1') {
//                System.out.println("SUCCESS");
                result = Math.min(result, cur.count);
                return;
            }
            for (int i = 0; i < 4; i++) {
                nx = (byte) (cur.x + dx[i]);
                ny = (byte) (cur.y + dy[i]);
                byte[] curkeys = new byte[6];
                keyT = 0;
                newKeyT = 0;
                for (int j = 0; j < 6; j++) {
                    curkeys[j] = cur.keys[j];
                    keyT += cur.keys[j];
                }
                visited[cur.x][cur.y][keyT] = true;

                if (!available(nx, ny, curkeys, keyT)) continue;
                if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                    if (curkeys[maze[nx][ny] - 'a'] == 0) {
                        curkeys[maze[nx][ny] - 'a'] = (byte) Math.pow(2, maze[nx][ny] - 97);
                        keyT += curkeys[maze[nx][ny] - 'a'];
                    }
                }
                q.offer(new Minsik(nx, ny, cur.count + 1, curkeys));
//                System.out.println(cur.x + ", " + cur.y);
//                System.out.println(nx + ", " + ny);
//                System.out.println("-------");
            }
        }
    }

    public static boolean available(int x, int y, byte[] keys, int keyT) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
//            System.out.println("1stStep");
            return false;
        }
        if (visited[x][y][keyT]) {
//            System.out.println("2ndStep");
            return false;
        }
        if (maze[x][y] == '#') {
//            System.out.println("3rdStep");
            return false;
        }
        if (maze[x][y] >= 'A' && maze[x][y] <= 'F') {
//            System.out.println("4thStep");
            if (keys[maze[x][y] - 'A'] == 0) {
                return false;
            }
        }
        return true;
    }
}
