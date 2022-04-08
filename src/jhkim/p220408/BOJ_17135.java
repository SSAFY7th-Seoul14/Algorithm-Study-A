package jhkim.p220408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17135 {

    static int N, M, D, map[][], enemies, result;
    static int[] archers = new int[3];
    static int temp[][], nx, ny;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Point> q;
    static boolean[][] visited;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                   enemies++;
                }
            }
        }
        chooseArcher(0, 0);
        System.out.println(result);
    }

    private static void chooseArcher(int start, int count) {
        if (count == 3) {
            result = Math.max(result, shoot());
            return;
        }
        for (int i = start; i < M; i++) {
            archers[count] = i;
            chooseArcher(i + 1, count + 1);
        }
    }

    private static int shoot() {
        int remove = 0;
        temp = new int[N + 1][M];
        Point[] targets;

        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }

        int rest = enemies;
        while (true) {
            if (rest == 0) break;
            targets = new Point[3];

            for (int i = 0; i < 3; i++) {
                int x = N;
                int y = archers[i];

                if (temp[x][y] == 1) {
                    targets[i] = new Point(x, y);
                } else {

                    q = new LinkedList<>();
                    visited = new boolean[N + 1][M];
                    visited[x][y] = true;
                    q.offer(new Point(x, y));
                    boolean flag = false;
                    int level = 0;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        if (level == D || flag) {
                            break;
                        }
                        while (--size >= 0) {
                            Point cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                nx = cur.x + dx[d];
                                ny = cur.y + dy[d];

                                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                                if (visited[nx][ny]) continue;
                                visited[nx][ny] = true;
                                if (temp[nx][ny] == 1) flag = true;
                                q.offer(new Point(nx, ny));
                            }
                        }
                        level++;
                    }
                    while (!q.isEmpty()) {
                        nx = q.peek().x;
                        ny = q.peek().y;
                        if (temp[nx][ny] == 1) {
                            if (targets[i] == null) {
                                targets[i] = q.poll();
                            } else if (targets[i].y > ny) {
                                targets[i] = q.poll();
                            } else {
                                q.poll();
                            }
                        } else {
                            q.poll();
                        }
                    }
                }
            }
            for(int i = 0; i < 3; i++) {
                if (targets[i] != null) {
                    if (temp[targets[i].x][targets[i].y] == 1) {
                        temp[targets[i].x][targets[i].y] = 0;
                        remove++;
                        rest--;
                    }
                }
            }
            rest -= move();
        }
        return remove;
    }

    private static int move() {
        int ans = 0;
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < M; j++) {
                if (i == N - 1 && temp[i][j] == 1) {
                    ans++;
                }
                temp[i][j] = temp[i - 1][j];
            }
        }
        Arrays.fill(temp[0], 0);
        return ans;
    }
}
