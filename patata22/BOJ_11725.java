import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11725 {
    static ArrayList<Integer>[] graph;
    static int[] parent;

    static void dfs(int i){
        for(int x:graph[i]){
            if(parent[x]==0) {
                parent[x] = i;
                dfs(x);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
        parent = new int[n+1];
        parent[1]=1;
        graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            int a=Integer.parseInt(temp[0]), b=Integer.parseInt(temp[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        for(int i=2;i<n+1;i++){
            System.out.println(parent[i]);
        }
    }
}
