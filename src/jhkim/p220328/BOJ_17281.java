package jhkim.p220328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17281 {

    static int N, hits[][], maxScore, perms[][] = new int[40320][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        hits = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                hits[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxScore = 0;
        play();

        System.out.println(maxScore);

    }

    private static void play() {
        perm(0);

        int score = 0, foul = 0, now = 0, inning = 0, hit = 0;
        Queue<Integer> status = new LinkedList<>();

        for (int i = 0; i < 40320; i++) {
            while (true) {
                if (inning >= N) break;
                hit = hits[inning][perms[i][now++]];
                if (hit == 0) {
                    foul++;
                } else if (hit == 4) {
                    score += status.size();
                    score++;
                    status.clear();
                } else {
                    while (!status.isEmpty()) {
                        if (status.peek() + hit >= 4) {
                            score++;
                            status.poll();
                        } else break;
                    }
                    int size = status.size();
                    for(int j = 0; j < size; j++) {
                        status.offer(status.poll() + hit);
                    }
                    status.offer(hit);
                }

                if (now >= 9) {
                    now = 0;
                }

                if (foul == 3) {
                    status.clear();
                    inning++;
                    foul = 0;
                }

            }

            if (score > maxScore) {
                maxScore = score;
            }
            score = 0;
            foul = 0;
            status = new LinkedList<>();
            now = 0;
            inning = 0;
        }

    }

    static int permCount = 0, num[] = new int[8];
    static boolean isSelected[] = new boolean[8];

    private static void perm(int count) {
        if (count == 8) {
            for (int i = 0; i < 9; i++) {
                if (i < 3) {
                    perms[permCount][i] = num[i];
                } else if (i == 3) {
                    perms[permCount][i] = 0;
                } else {
                    perms[permCount][i] = num[i - 1];
                }
            }
            permCount++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            num[count] = i + 1;
            perm(count + 1);
            isSelected[i] = false;
        }

    }
}
