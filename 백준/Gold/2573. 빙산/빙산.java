import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static Queue<int[]> q;

    public static void melt(){
        Queue<int[]> q2 = new ArrayDeque<>();
        while(!q.isEmpty()){
            int[] now = q.poll();
            int c = 0;
            for(int d = 0; d<4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx<0 || nx >=N || ny<0 || ny>=M || arr[nx][ny]!= 0) continue;
                c++;

            }
            q2.add(new int[]{now[0], now[1],arr[now[0]][now[1]] - c});
        }

        while(!q2.isEmpty()){
            int[] now = q2.poll();
            if(now[2] <= 0){
                arr[now[0]][now[1]] = 0;
            }
            else{
                arr[now[0]][now[1]] = now[2];
                q.add(new int[]{now[0], now[1]});
            }
        }

    }

    public static boolean count(){
        Queue<int[]> q2 = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int c = 0;

        for(int i =0; i<N; i++){
            for(int j =0; j<M;j++){
                if(!visited[i][j] && arr[i][j]!=0){
                    c++;
                    q2.add(new int[]{i,j});
                    visited[i][j] = true;

                    while(!q2.isEmpty()){
                        int[] now = q2.poll();

                        for(int d = 0; d<4;d++){
                            int nx = now[0]+ dx[d];
                            int ny = now[1]+ dy[d];

                            if(nx<0 || nx >=N || ny<0 || ny>=M || arr[nx][ny]== 0 || visited[nx][ny]) continue;
                            q2.add(new int[]{nx,ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                if(c >=2) return true;
            }
        }

        return false;
    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int time =0;

        arr = new int[N][M];
        q = new ArrayDeque<>();

        for(int i =0; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) q.add(new int[]{i,j});
            }
        }

        boolean f = false;

        while(!q.isEmpty()){
            time++;
            melt();
            if(count()){
                f = true;
                break;
            }
        }

        if(f)System.out.println(time);
        else System.out.println(0);
    }
}
