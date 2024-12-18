import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[][] arr;
    public static int[] dx ={-1,1,0,0};
    public static int[] dy ={0,0,-1,1};
    public static int[][] visited;
    public static int num;

    public static boolean bfs(int i,int j){
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = num;
        q.add(new int[]{i,j});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int nx = now[0] + dx[arr[x][y]];
            int ny = now[1] + dy[arr[x][y]];

            if(visited[nx][ny]==0){
                visited[nx][ny] = num;
                q.add(new int[]{nx,ny});
            }
            else if(visited[nx][ny]!= num){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num =0;
        int res =0;

        arr = new int[N][M];
        visited = new int[N][M];

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char c = str.charAt(j);
                if(c == 'U'){
                    arr[i][j] = 0;
                }
                else if(c=='D'){
                    arr[i][j] = 1;
                }
                else if(c == 'L'){
                    arr[i][j] = 2;
                }
                else if(c == 'R'){
                    arr[i][j] = 3;
                }
            }
        }

        for(int i =0;i<N;i++){
            for(int j =0; j<M;j++){
                if(visited[i][j]==0){
                    num++;
                    if(bfs(i,j)){
                        res++;
                    }
                }
            }
        }

        System.out.print(res);
    }
}
