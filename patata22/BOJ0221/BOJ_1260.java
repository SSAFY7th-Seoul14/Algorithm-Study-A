package BOJ0221;

import java.util.*;

public class BOJ_1260 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v]=true;
        sb.append(v);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int x : graph[now]){
                if(!visited[x]){
                    sb.append(" "+x);
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }
    static void dfs(int i){
        visited[i]=true;
        sb.append(i+" ");
        for(int x: graph[i]){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(), m=sc.nextInt(), v= sc.nextInt();
        graph=new ArrayList[n+1];
        for(int i=1;i<n+1;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            int a=sc.nextInt(), b= sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1;i<n+1;i++){
            if(!graph[i].isEmpty()) graph[i].sort((o1, o2) -> o1-o2);
        }

        sb=new StringBuilder();
        visited= new boolean[n+1];
        dfs(v);
        System.out.println(sb);
        sb=new StringBuilder();
        visited=new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }
}
