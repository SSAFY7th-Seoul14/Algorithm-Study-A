import java.io.IOException;
import java.util.Scanner;

public class BOJ_1991 {
    static String[][] graph;
    static void front(char i){
        System.out.print(i);
        if(!graph[i-65][1].equals(".")) front(graph[i-65][1].charAt(0));
        if(!graph[i-65][2].equals(".")) front(graph[i-65][2].charAt(0));
    }
    static void middle(char i){
        if(!graph[i-65][1].equals(".")) middle(graph[i-65][1].charAt(0));
        System.out.print(i);
        if(!graph[i-65][2].equals(".")) middle(graph[i-65][2].charAt(0));
    }
    static void back(char i){
        if(!graph[i-65][1].equals(".")) back(graph[i-65][1].charAt(0));
        if(!graph[i-65][2].equals(".")) back(graph[i-65][2].charAt(0));
        System.out.print(i);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        graph = new String[n][3];
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            graph[temp[0].charAt(0) - 65] = temp;
        }
            front('A');
            System.out.println();
            middle('A');
            System.out.println();
            back('A');
            System.out.println();

    }

}
