import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static int N, start[]= new int[2],end[]= new int[2],result,map[][] = new int[301][301];
    static int dir [][]={{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
    static boolean visited[][];
    static ArrayList<Integer>temp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1]= Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0]= Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            result =0;
            if(start[0] ==end[0] &&start[1]==end[1]) System.out.println(0);
            else{
                visited =new boolean[N][N];
                BFS();

            }
        }
    }
    static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        map[start[0]][start[1]] =1;
        while (!q.isEmpty()){
            int temp[] = q.poll();
            visited[temp[0]][temp[1]] =true;
            for(int i=0; i<8;i++){
                int x = temp[0] +dir[i][0];
                int y = temp[1] +dir[i][1];
                if(0<=x&&0<=y&&x<N&&y<N){
                    if(x==end[0]&&y==end[1]) {
                        System.out.println(map[temp[0]][temp[1]]);
                        return;
                    }
                    if(!visited[x][y]){
                        q.offer(new int[]{x,y});
                        visited[x][y] =true;
                        map[x][y]= map[temp[0]][temp[1]] +1;
                    }
                }
            }
        }
    }
}