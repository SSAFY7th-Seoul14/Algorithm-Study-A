package jhkim.p220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JOL_1082_BFS {

    static char map[][];
    static int visited[][];
    static int R, C, startX, startY, homeX, homeY, result, nx, ny;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Queue<Node> q = new LinkedList<>();

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R][C];
        String line = null;

        for (int i = 0; i < R; i++) {
            line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    q.offer(new Node(i, j));
                    map[i][j] = '.';
                }
                if (map[i][j] == 'D') {
                    homeX = i;
                    homeY = j;
                }
            }
        }

        result = Integer.MAX_VALUE;
        bfs();

        if (result == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(result);
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();

            fire();

            while (--size >= 0) {
                Node cur = q.poll();
                for (int a = 0; a < 4; a++) {
                    nx = cur.x + dx[a];
                    ny = cur.y + dy[a];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }

                    if (map[nx][ny] == '.' && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        q.offer(new Node(nx, ny));
                    } else if (map[nx][ny] == 'D' && visited[nx][ny] == 0) {
                        result = visited[cur.x][cur.y] + 1;
                        return;
                    }
                }
            }
        }
    }

    private static void fire() {
        char[][] tempmap = new char[R][C];

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

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = tempmap[i][j];
            }
        }
    }
}
