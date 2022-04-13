package jhkim.p220331;
/*
1.문제에서 요구하는 답을 문장으로 적어 봄.
ex) d[n]:n번째 층을 칠할 수 있는 방법의 수. f(8): 8층을 칠할 수 있는 방법의 수

2.문제에 나와 있는 변수(n)만큼의 메모 배열 생성
3.작은 문제를 풀어 배열에 저장(초기값): f(1), f(2)..
4.문제의 크기를 크게 만들어서 점점 큰 문제 풀기: 반복문 등
5.문제 해결!
*/
public class T_P1_Sol1 {
    public static void main(String[] args) {
        int N = 8; //f(8)을 구해야 함

        //memo를 위한 배열 생성
        //d[N][0] :N층을 노랑으로 칠할수 있는 가지수. d[N][1] :N층을 파랑으로 칠할수 있는 가지수
        int[][] d = new int[N+1][2];
        int yellow = 0, blue = 1;

        d[1][yellow] = 1;
        d[1][blue] = 1;

        for (int i = 2; i <= N; i++) {
            //i번째 층을 노랑으로 칠할 수 있는 경우:아래층(i-1)이 노랑+파랑의 경우
            d[i][yellow] = d[i-1][yellow] + d[i-1][blue];

            //i번째 층을 파랑으로 칠할 수 있는 경우:아래층(i-1)이 노랑의 경우
            d[i][blue] = d[i-1][yellow];
        }

        System.out.println(d[N][yellow] + d[N][blue]);
    }

}
