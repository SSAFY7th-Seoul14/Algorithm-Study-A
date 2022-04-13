package jhkim.p220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_1082 {

    static char map[][], tempmap[][];
    static boolean visited[][];
    static int R, C, startX, startY, homeX, homeY, result, nx, ny;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        tempmap = new char[R][C];
        visited = new boolean[R][C];
        String line = null;

        for (int i = 0; i < R; i++) {
            line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                tempmap[i][j] = map[i][j];
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                }
                if (map[i][j] == 'D') {
                    homeX = i;
                    homeY = j;
                }
            }
        }

        result = Integer.MAX_VALUE;
        wayBackHome(startX, startY, 0, map, tempmap, visited);

        if (result == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(result);
        }
    }

    private static void wayBackHome(int x, int y, int count, char[][] map, char[][] tempmap, boolean[][] visited) {
        if (map[x][y] != '.' || visited[x][y]) {
            if (map[x][y] == 'D') {
                result = Math.min(result, count);
            }
            return;
        }

        tempmap = fire(map, tempmap);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = tempmap[i][j];
            }
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                continue;
            }
            wayBackHome(nx, ny, count + 1, map, tempmap, visited);
        }
    }

    private static char[][] fire(char[][] map, char[][] tempmap) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempmap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    for (int a = 0; a < 4; a++) {
                        nx = i + dx[a];
                        ny = j + dy[a];

                        if (nx < 0 || nx >= R || ny < 0 || ny >= C || tempmap[nx][ny] != '.') {
                            continue;
                        }
                        tempmap[nx][ny] = '*';
                    }
                }
            }
        }

        return tempmap;
    }
}
