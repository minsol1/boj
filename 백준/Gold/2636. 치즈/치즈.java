import java.io.*;
import java.util.*;

public class Main {

    public static int N,M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int time,res;
    public static Queue<int[]>q;

    public static void bfs(){
        Queue<int[]> q2 = new ArrayDeque<>();

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now[0]+ dx[d];
                int ny = now[1]+ dy[d];

                if(nx <0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;

                if(arr[nx][ny]==0){
                    q.add(new int[]{nx,ny});
                }
                else{
                    q2.add(new int[]{nx,ny});
                }
                visited[nx][ny]= true;
            }
        }
        q= q2;
        if(!q2.isEmpty()){
            res = q2.size();
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        q = new ArrayDeque<>();
        time = 0;
        res = 0;

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new int[]{0,0});
        visited[0][0]= true;
        while(!q.isEmpty()){
            time++;
            bfs();
        }
        System.out.println(time-1);
        System.out.println(res);

    }
}
