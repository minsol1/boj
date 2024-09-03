import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static int N;
    public static boolean[][] visited;
    public static int res =0;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1};


    public static int cnt(int n){
        visited = new boolean[N][N];
        int cnt =0;

        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&& arr[i][j]>n){
                    cnt++;
                    bfs(i,j,n);
                }
            }
        }

        return cnt;
    }

    public static void bfs(int i, int j, int n){

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0;d<4;d++){
                int nx = now[0]+ dx[d];
                int ny = now[1]+ dy[d];

                if(nx<0|| nx>=N || ny<0 || ny>=N){
                    continue;
                }
                if(!visited[nx][ny] && arr[nx][ny]>n){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N;j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<=100;i++){
            int c = cnt(i);
            res = res>c? res:c;
        }

        System.out.println(res);
    }
}
