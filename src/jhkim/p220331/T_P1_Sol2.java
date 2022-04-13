package jhkim.p220331;
/*
1.문제에서 요구하는 답을 문장으로 적어 봄.
ex) d[n]:n번째 층을 칠할 수 있는 방법의 수. f(8): 8층을 칠할 수 있는 방법의 수

2.문제에 나와 있는 변수(n)만큼의 메모 배열 생성
3.작은 문제를 풀어 배열에 저장(초기값): f(1), f(2)..
4.문제의 크기를 크게 만들어서 점점 큰 문제 풀기: 반복문 등
5.문제 해결!
*/
public class T_P1_Sol2 {
    public static void main(String[] args) {
        int N = 8; //f(8)을 구해야 함

        int down_yellow = 1, down_blue = 1;//초기값. 1층값부터
        int up_yellow = 0, up_blue = 0;//2층값부터

        for (int i = 2; i <= N; i++) {
            //i번째 층을 노랑으로 칠할 수 있는 경우:아래층(i-1)이 노랑+파랑의 경우
            up_yellow = down_yellow + down_blue;

            //i번째 층을 파랑으로 칠할 수 있는 경우:아래층(i-1)이 노랑의 경우
            up_blue = down_yellow;

            down_yellow = up_yellow;
            down_blue = up_blue;
        }

        System.out.println(up_yellow + up_blue);
    }

}
