import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int num = Integer.parseInt(br.readLine());
        char array[] = br.readLine().toCharArray();

        Stack<Double> op = new Stack<>();
        Map< Character, Double > map = new HashMap< >();


        char key = 'A';
        for (int i = 0; i < num; i++) {
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        // array의 길이만큼 반복문 수행
        for (int i = 0; i < array.length; i++) {
            // 인덱스의 값이 A-Z인 경우
            if ('A' <= array[i] && array[i] <= 'Z') {
                op.push(map.get(array[i]));
            }
            // 그외의 경우
            else {
                double answer1 = op.pop();
                double answer2 = op.pop();

                switch (array[i]) {
                    case '+':
                        op.push(answer2 + answer1);
                        break;
                    case '-':
                        op.push(answer2 - answer1);
                        break;
                    case '*':
                        op.push(answer2 * answer1);
                        break;
                    case '/':
                        op.push(answer2 / answer1);
                        break;
                }
            }
        }
        // 결과 값 출력
        System.out.println(String.format("%.2f", op.pop()));
    }
}
