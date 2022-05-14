package jhkim.p220514;

import java.io.*;
import java.util.Arrays;
import java.util.Spliterator;

public class SFT_01 {

    static String msg, key, passwort;
    static keyMap[][] keyTable;
    static keyMap[] keyLoca;
    static boolean[] used;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static class keyMap {
        int r, c;
        char val;

        public keyMap(int r, int c, char val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

    }

    public static void main(String[] args) throws IOException {

        msg = br.readLine();
        key = br.readLine();

        keyTable = new keyMap[5][5];
        keyLoca = new keyMap[26];
        used = new boolean[26];

        used['J' - 'A'] = true;
        makeKeyTable();

        passwort = cipher();

        System.out.println(playfair());
        br.close();
    }

    private static void makeKeyTable() {
        int now = 0;
        char value = 'A';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (key.length() > now) {
                    value = key.charAt(now++);
                    while (true) {
                        if (!used[value - 'A']) {
                            used[value - 'A'] = true;
                            break;
                        } else {
                            if (key.length() <= now) {
                                for (int k = 0; k < 26; k++) {
                                    if (used[k]) continue;
                                    else {
                                        value = (char) ('A' + k);
                                        used[value - 'A'] = true;
                                        break;
                                    }
                                }
                                break;
                            }
                            value = key.charAt(now++);
                        }
                    }
                } else {
                    for (int k = 0; k < 26; k++) {
                        if (used[k]) continue;
                        else {
                            value = (char) ('A' + k);
                            used[k] = true;
                            break;
                        }
                    }
                }
                keyTable[i][j] = new keyMap(i, j, value);
                keyLoca[value - 'A'] = new keyMap(i, j, value);
            }
        }
    }

    private static String cipher() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            if (i < msg.length() - 1 && msg.charAt(i) == msg.charAt(i + 1)) {
                if(msg.charAt(i) == 'X') {
                    sb.append(msg.charAt(i)).append('Q');
                } else {
                    sb.append(msg.charAt(i)).append('X');
                }
            } else if (i == msg.length() - 1) {
                sb.append(msg.charAt(i)).append('X');
            } else {
                sb.append(msg.charAt(i)).append(msg.charAt(++i));
                if(i + 1 == msg.length()) break;
            }
        }
        return sb.toString();
    }

    private static String playfair() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passwort.length(); i += 2) {
            keyMap one = keyLoca[passwort.charAt(i) - 'A'];
            keyMap two = keyLoca[passwort.charAt(i + 1) - 'A'];

            if (one.r == two.r) {
                int c = one.c;
                if(c == 4) {
                    sb.append(keyTable[one.r][0].val);
                } else {
                    sb.append(keyTable[one.r][c + 1].val);
                }
                c = two.c;
                if(c == 4) {
                    sb.append(keyTable[one.r][0].val);
                } else {
                    sb.append(keyTable[one.r][c + 1].val);
                }
            } else if (one.c == two.c) {
                int r = one.r;
                if(r == 4) {
                    sb.append(keyTable[0][one.c].val);
                } else {
                    sb.append(keyTable[r + 1][one.c].val);
                }
                r = two.r;
                if(r == 4) {
                    sb.append(keyTable[0][one.c].val);
                } else {
                    sb.append(keyTable[r + 1][one.c].val);
                }
            } else {
                int r1 = one.r;
                int c1 = one.c;
                int r2 = two.r;
                int c2 = two.c;
                sb.append(keyTable[r1][c2].val).append(keyTable[r2][c1].val);
            }
        }
        return sb.toString();
    }

}
