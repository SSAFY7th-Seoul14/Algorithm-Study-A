import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1967 {
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    static int n,far,answer=0;
    static void dfs(int now, int weight){

        if(weight>answer){
            answer=weight;
            far=now;
        }
        for(int[] x:graph[now]){
            int v=x[0],w=x[1];
            if(!visited[v]){
                visited[v]=true;
                dfs(v,weight+w);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n=Integer.parseInt(sc.nextLine());
        graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            String[] temp = sc.nextLine().split(" ");
            int a=Integer.parseInt(temp[0]),b=Integer.parseInt(temp[1]),c=Integer.parseInt(temp[2]);
            int[] temp1={b,c};
            int[] temp2={a,c};
            graph[a].add(temp1);
            graph[b].add(temp2);
        }
        visited=new boolean[n+1];
        visited[1]=true;
        dfs(1,0);
        answer=0;
        visited=new boolean[n+1];
        visited[far]=true;
        dfs(far,0);
        System.out.println(answer);

    }
}
