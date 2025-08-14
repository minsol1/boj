import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,res;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void dfs(int x, int y, int cnt){
        if( cnt == 3){
            bfs();
            int c=0;
            for(int i =0; i<N;i++){
                for(int j =0;j<M;j++){
                    if(arr[i][j]== 0 && !visited[i][j]){
                        c++;
                    }
                }
            }
            res = res > c ? res : c;
            return;
        }

        for(int i =x; i<N;i++){
            for(int j =y; j<M;j++){
                if( arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(i, 0,cnt+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                if(arr[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx<0 || nx>=N || ny <0 || ny >=M || visited[nx][ny]) continue;

                if(arr[nx][ny] == 0){
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }

    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        arr = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        System.out.println(res);

    }
}
