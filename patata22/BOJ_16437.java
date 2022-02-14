import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_16437 {
    static ArrayList<Integer>[] graph;
    static HashMap<Integer,Long> island;
    static long dfs(int now){
        long count;
        long temp=island.get(now);
        if(temp>=0) count=temp;
        else count=0;
        for(int x:graph[now]) count+=dfs(x);
        if(temp<0){
            if(count+temp>=0){
                count+=temp;
                island.put(now,(long)0);
            }
            else{
                island.put(now, temp+count);
                count=0;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        graph = new ArrayList[n+1];
        island = new HashMap<>();
        island.put(1, 0L);
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<Integer>();
        for(int i=2;i<n+1;i++){
            String[] temp = sc.nextLine().split(" ");
            if(temp[0].equals("S")) island.put(i, (long) Integer.parseInt(temp[1]));
            else island.put(i, (long) -Integer.parseInt(temp[1]));
            graph[Integer.parseInt(temp[2])].add(i);

        }

        System.out.println(dfs(1));


    }
}
