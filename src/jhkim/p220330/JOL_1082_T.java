package jhkim.p220330;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1.data 입력-불위치, 용사의 위치,목적지
 * 2.매분마다-불 퍼지고 용사이동하고
 * 3.용사 이동시에->도착지에 도달하면 끝
 * 4.다 이동한 후에 상태체크("impossible")
 */
public class JOL_1082_T {
    static Queue<Point> fire = new LinkedList<>();
    static Queue<Point> hero = new LinkedList<>();

    // 4방
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static int row, col;// 행열
    static char[][] map;// 입력값
    static boolean[][] visit;// 방문체크
    static int time;// 탈출시간
    static boolean possible, running;// false

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(src);
        row = sc.nextInt();//행
        col = sc.nextInt();//열

        map = new char[row][col];
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = sc.next().toCharArray();//행 입력

            for (int j = 0; j < col; j++) {
                if(map[i][j] == '*')
                    fire.add(new Point(i, j));

                if(map[i][j] == 'S')
                    hero.add(new Point(i, j));
            }
        }
        //System.out.println(Arrays.deepToString(map));

        //매분마다 불 퍼지고 용사 이동하고
        running = true;
        time = 0;
        possible = false;//탈출 가능 여부의 변수
        //1분동안 불이 퍼지고 용사가 이동하는 부분
        while(running) {
            goFire();
            goHero();

            //둘 다 더이상 이동할 곳이 없다면
            if(fire.size() == 0 && hero.size() == 0)
                running = false;
        }

        if(!possible)
            System.out.println("impossible");
    }

    private static void goHero() {
        time++;
        int size = hero.size();
        for (int i = 0; i < size; i++) {
            Point h = hero.poll();

            for (int j = 0; j < 4; j++) {
                int nx = h.x + dx[j];
                int ny = h.y + dy[j];

                if(!isIn(nx, ny)) continue;
                if(map[nx][ny] == 'D') {//도착!!!
                    System.out.println(time);
                    possible = true;
                    running = false;
                    return;
                }
                if(map[nx][ny] == '.' && !visit[nx][ny]) {//도착 못함. 계속 이동해야 해
                    map[nx][ny] = '.';//용사이동
                    visit[nx][ny] = true;//방문처리
                    hero.add(new Point(nx, ny));
                }
            }
        }
    }

    //단위시간(1분)에 4방으로 퍼짐
    private static void goFire() {
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            Point f = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = f.x + dx[j];
                int ny = f.y + dy[j];

                if(!isIn(nx, ny)) continue;
                if(map[nx][ny] == '.' && !visit[nx][ny]) {
                    map[nx][ny] = '*';//불 자리
                    visit[nx][ny] = true;//방문처리

                    fire.add(new Point(nx, ny));
                }
            }
        }
    }//goFire()

    private static boolean isIn(int nx, int ny) {
        return (nx >= 0 && nx < row && ny >= 0 && ny < col);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String src = "3 3\r\n" + "D.*\r\n" + "...\r\n" + ".S.";
}
