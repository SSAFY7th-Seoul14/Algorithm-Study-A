package jhkim.p220328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17281_Dev {

    static int N, hits[][], maxScore;

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
        perm(0);

        System.out.println(maxScore);

    }
    static Queue<Integer> status = new LinkedList<>();
    static int score = 0, foul = 0, now = 0, inning = 0, hit = 0;

    private static void play(int[] order) {

        score = 0;
        foul = 0;
        now = 0;
        inning = 0;

        status.clear();

        if (order != null) {
            while (true) {
                if (inning >= N) break;
                hit = hits[inning][order[now++]];
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
                    for (int j = 0; j < size; j++) {
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
        }

    }

    static int num[] = new int[9];
    static boolean isSelected[] = new boolean[9];

    private static void perm(int count) {
        if (count == 9) {
            play(num);
            return;
        }
        if (count == 3) {
            num[count] = 0;
            perm(count + 1);
        }

        for (int i = 1; i < 9; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            num[count] = i;
            perm(count + 1);
            isSelected[i] = false;
        }
    }
}
