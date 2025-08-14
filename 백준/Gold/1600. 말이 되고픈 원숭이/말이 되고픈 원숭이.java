import java.io.*;
import java.util.*;

public class Main {

    public static int K,N,M;
    public static int[][] arr;
    public static int[][][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int[] hx = {1,2,2,1,-1,-2,-2,-1};
    public static int[] hy = {-2,-1,1,2,-2,-1,1,2};

    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        visited[0][0][0] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d<4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >=N || ny<0 || ny >=M|| visited[nx][ny][now[2]] !=-1 || arr[nx][ny] !=0) continue;

                q.add(new int[]{nx,ny,now[2]});
                visited[nx][ny][now[2]] = visited[now[0]][now[1]][now[2]] +1;
            }
            if(now[2]<K){
                for(int d = 0; d<8;d++){
                    int nx = now[0] + hx[d];
                    int ny = now[1] + hy[d];

                    if(nx < 0 || nx >=N || ny<0 || ny >=M|| visited[nx][ny][now[2]+1] !=-1|| arr[nx][ny] !=0) continue;

                    q.add(new int[]{nx,ny,now[2]+1});
                    visited[nx][ny][now[2]+1] = visited[now[0]][now[1]][now[2]] +1;

                }
            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M][K+1];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                for(int k = 0; k<=K;k++){
                    visited[i][j][k] = -1;
                }
            }
        }

        bfs();

        int res = Integer.MAX_VALUE;

        for(int k = 0; k<=K;k++){
            int n = visited[N-1][M-1][k];
            if(n == -1) continue;
            res = res < n ?res : n;
        }
        if(res == Integer.MAX_VALUE ) res = -1;
        System.out.println(res);

    }
}
