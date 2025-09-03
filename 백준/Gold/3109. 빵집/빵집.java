import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1};
    public static int res;

    public static boolean dfs(int x,int y){

        for(int d = 0; d<3;d++){
            int nx = x + dx[d];
            int ny = y + 1;

            if(nx < 0 || nx >=N || ny >=M || arr[nx][ny]=='x' || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            if(ny == M-1){
                res++;
                return true;
            }

            if(dfs(nx,ny)) return true;

        }
        return false;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i =0; i<N;i++){
            dfs(i,0);
        }

        System.out.println(res);

    }
}
