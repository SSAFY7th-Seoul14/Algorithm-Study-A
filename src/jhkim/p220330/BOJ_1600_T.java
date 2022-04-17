package jhkim.p220330;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//최단거리를 구해야 하므로 bfs
//k+1횟수만큼 방문배열 만들기

public class BOJ_1600_T {
    //원숭이 처럼 이동시
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    //말처럼 이동시
    static int[] hx = {-2,-2, 2, 2, 1,-1, 1,-1};
    static int[] hy = { 1,-1, 1,-1, 2, 2,-2,-2};

    static int w, h, K;//K:말처럼 뛸수 있는 횟수(0~K번 뛰어볼수 있음)
    static int[][] map;
    static boolean[][][] visit;//방문체크

    static class Monkey{
        int x,y;//좌표
        int count;//총 움직인 횟수
        int k;//말처럼 움직인 횟수

        public Monkey(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Monkey> q = new LinkedList<>();

        K = sc.nextInt();//말처럼
        w = sc.nextInt();
        h = sc.nextInt();

        map = new int[h][w];
        visit = new boolean[K+1][h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = sc.nextInt();
            }
        }//입력

        //뛰어보기: 시작지점에서부터 원숭이처럼->말처럼
        visit[0][0][0] = true;
        q.add(new Monkey(0, 0, 0, 0));

        while(!q.isEmpty()) {
            Monkey m = q.poll();

            //1)도착점에 왔나? -> 이동한 횟수 출력하고 종료
            if(m.x == h-1 && m.y == w-1) {
                System.out.println(m.count);
                return;
            }

            //2-1)아직 도착 안했어.원숭이처럼 4방이동
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];
                int count = m.count;//0
                int horseMove = m.k;//0

                if(!isIn(nx, ny)) continue;
                if(map[nx][ny] == 1) continue;//벽
                if(visit[horseMove][nx][ny]) continue;//

                visit[horseMove][nx][ny] = true;
                Monkey qq = new Monkey(nx, ny, count+1, horseMove);
                q.add(qq);
            }

            //2-2)말처럼 8방이동
            if(m.k == K) continue;
            for (int i = 0; i < 8; i++) {
                int nx = m.x + hx[i];
                int ny = m.y + hy[i];
                int count = m.count;//0
                int horseMove = m.k + 1;//1

                if(!isIn(nx, ny)) continue;
                if(map[nx][ny] == 1) continue;//벽
                if(visit[horseMove][nx][ny]) continue;//

                visit[horseMove][nx][ny] = true;
                q.add(new Monkey(nx, ny, count+1, horseMove));
            }//like horse
        }//while

        System.out.println(-1);
    }


    private static boolean isIn(int nx, int ny) {
        return (nx >= 0 && nx < h && ny >= 0 && ny < w);
    }
}