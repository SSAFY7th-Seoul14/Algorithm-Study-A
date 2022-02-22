package BOJ0221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16397 {
    static int N,T,G;
    static boolean[] visited;

    static int sol(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N]=true;
        int t=0;
        while(!q.isEmpty()&&t<=T){
            int u = q.size();
            for(int v=0;v<u;v++){
            int x = q.poll();
            if(x==G) return t;
            if(x<99999&&!visited[x+1]) {
                visited[x+1] =true;
                q.add(x+1);
            }
            if(0<x&&x<5&&!visited[2*x-1]){
                visited[2*x-1]=true;
                q.add(2*x-1);
            }else if(5<=x&&x<50&&!visited[2*x-10]){
                visited[2*x-10]=true;
                q.add(2*x-10);
            }else if(50<=x&&x<500&&!visited[2*x-100]){
                visited[2*x-100]=true;
                q.add(2*x-100);
            }else if(500<=x&&x<5000&&!visited[2*x-1000]){
                visited[2*x-1000]=true;
                q.add(2*x-1000);
            }else if(5000<=x&&x<50000&&!visited[2*x-10000]){
                visited[2*x-10000]=true;
                q.add(2*x-10000);
            }
            }
            t+=1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt(); T=sc.nextInt(); G=sc.nextInt();
        visited= new boolean[100000];
        int answer=sol();
        if(answer==-1) System.out.println("ANG");
        else System.out.println( answer);
    }
}
