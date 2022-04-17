package jhkim.p220405;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656 {

    static int N, W, H, board[][], temp[][], result, nx, ny, total;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean visited[][];

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            result = 0;
            total = 0;

            board = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j] != 0) total++;
                }
            }

            drop(0, board, 0);

            result = total - result;
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void drop(int count, int[][] board, int clear) {
        if (count == N) {
            result = Math.max(result, clear);
            return;
        }
        temp = new int[H][W];

        for (int i = 0; i < W; i++) {
            for (int a = 0; a < H; a++)
            {
                for (int b = 0; b < W; b++) {
                    temp[a][b] = board[a][b];
                }
            }
            for (int j = 0; j < H; j++) {
                if (board[j][i] == 0) {
                    continue;
                } else {
                    int nowClear = brickBreak(j, i);
                    drop(count + 1, temp, clear + nowClear);
                    break;
                }
            }
        }

        result = Math.max(result, clear);
        return;
    }

    private static int brickBreak(int x, int y) {
        int cnt = 0;
        visited = new boolean[H][W];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            int curX = cur.x;
            int curY = cur.y;
            if(visited[curX][curY]) continue;

            if(temp[curX][curY] > 1) {
                for (int idx = 0; idx < 4; idx++) {
                    nx = curX;
                    ny = curY;
                    for (int i = 0; i < temp[curX][curY] - 1; i++) {
                        nx += dx[idx];
                        ny += dy[idx];

                        if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                            continue;
                        }
                        if (temp[nx][ny] == 0) continue;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            temp[curX][curY] = 0;
            visited[curX][curY] = true;
            cnt++;
        }
        organize();
        return cnt;
    }

    private static void organize() {

        for (int i = 0; i < W; i++) {
            int bottom = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (temp[j][i] == 0 || bottom >= H) {
                    continue;
                } else {
                    if (bottom > j) {
                        temp[bottom][i] = temp[j][i];
                        temp[j][i] = 0;
                    }
                    bottom--;
                }
            }
        }
    }
}
