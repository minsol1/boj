import java.io.*;
import java.util.*;

public class Main {
    public static char[][] arr;
    public static boolean[][] visited;
    public static boolean[][] seven;
    public static int res;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void dfs(int x,int y, int S, int Y){
        if(Y==4) return;
        if(S+Y>7) return;

        if(x>=5) {
            if(S+Y == 7){
                for(int i =0; i<5;i++){
                    for(int j =0;j<5;j++){
                        if(seven[i][j]){
                            if(bfs(i,j)) res++;
                            return;
                        }
                    }
                }
            }
            return;
        }

        int ny = (y + 1)%5;
        int nx = x + (y+1)/5;

        seven[x][y] = true;
        if(arr[x][y]=='S') dfs(nx,ny,S+1,Y);
        else dfs(nx,ny,S,Y+1);
        seven[x][y] = false;
        dfs(nx,ny,S,Y);

    }

    public static boolean bfs(int x,int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[5][5];
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int c = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            c++;
            for(int d = 0;d <4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0|| nx>=5||ny<0 || ny >=5 || visited[nx][ny] || !seven[nx][ny]) continue;

                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return c==7;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        seven = new boolean[5][5];
        res = 0;

        for(int i =0;i<5;i++){
            String str = br.readLine();
            for(int j =0; j<5;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(0,0,0,0);

        System.out.println(res);
    }
}
