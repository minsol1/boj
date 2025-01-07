import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[][]arr;
    public static int[][] cnt;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int res =-1;
    public static Queue<int[]> q;


    public static void bfs(){
        Queue<int[]> q2 = new ArrayDeque<>();

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];

                if(nx<0 || nx>=N+2 || ny<0 ||ny>=M+2||visited[nx][ny]) continue;

                if(arr[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
                else{
                    cnt[nx][ny]++;
                    if(cnt[nx][ny]==2){
                        q2.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        q = q2;
        for(int[] n : q2){
            arr[n[0]][n[1]]=0;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N+2][M+2];
        cnt = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];
        q = new ArrayDeque<>();

        for(int i =1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<M+1;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            bfs();
            res++;
        }

        System.out.println(res);
    }
}
