import java.util.*;
import java.io.*;

public class Main {
    public static char[][]arr;
    public static int[][] visited;
    public static int N,M;
    public static int res =0;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void bfs(int x,int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new int[N][M];
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                visited[i][j] = -1;
            }
        }
        q.add(new int[]{x,y});
        int max =0;
        visited[x][y] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d =0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx<0 || nx>=N || ny<0 || ny >=M|| visited[nx][ny]!=-1|| arr[nx][ny]=='W')
                    continue;

                q.add(new int[]{nx,ny});
                visited[nx][ny] = visited[now[0]][now[1]]+1;
                max = max > visited[nx][ny]?max : visited[nx][ny];
            }
        }
        res = res >max ? res:max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<M;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(arr[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(res);
    }
}
