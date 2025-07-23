import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int res1, res2;

    public static void bfs(int x, int y, char color, boolean rg){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];

                if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;
                if((color == 'R' || color == 'G') && rg ){
                    if(arr[nx][ny] == 'R' || arr[nx][ny] == 'G'){
                        q.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
                else{
                    if(arr[nx][ny] == color){
                        q.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i =0;i<N;i++){
            String st = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = st.charAt(j);
            }
        }

        visited = new boolean[N][N];
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(!visited[i][j]){
                    res1++;
                    bfs(i,j,arr[i][j],false);
                }
            }
        }
        visited = new boolean[N][N];
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(!visited[i][j]){
                    res2++;
                    bfs(i,j,arr[i][j],true);
                }
            }
        }
        System.out.println(res1+" "+res2);

    }
}
