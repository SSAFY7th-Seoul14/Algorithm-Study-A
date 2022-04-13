package jhkim.p220407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {

    static int N, M, city[][], x, y, result, resultTemp, distance, nx, ny, temp;
    static ArrayList<Point> chickens, houses;
    static ArrayList<Point[]> survivedChicks;
    static Point[] now;

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

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        now = new Point[M];
        city = new int[N][N];
        survivedChicks = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chickens.add(new Point(i, j));
                    city[i][j] = 0;
                }
                if (city[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        survive(0, 0);

        for (int i = 0; i < survivedChicks.size(); i++) {
            resultTemp = 0;
            for (int j = 0; j < houses.size(); j++) {
                distance = Integer.MAX_VALUE;
                x = houses.get(j).x;
                y = houses.get(j).y;
                for (int k = 0; k < M; k++) {
                    nx = survivedChicks.get(i)[k].x;
                    ny = survivedChicks.get(i)[k].y;
                    temp = Math.abs(x - nx) + Math.abs(y - ny);
                    distance = Math.min(temp, distance);
                }
                resultTemp += distance;
            }
            result = Math.min(result, resultTemp);
        }
        System.out.println(result);

    }

    private static void survive(int start, int count) {
        if (count == M) {
            Point[] up = new Point[M];
            for (int i = 0; i < M; i++) {
                up[i] = now[i];
            }
            survivedChicks.add(up);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            now[count] = new Point(chickens.get(i).x, chickens.get(i).y);
            survive(i + 1, count + 1);
        }
    }
}
