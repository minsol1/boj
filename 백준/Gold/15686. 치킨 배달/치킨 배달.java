import java.io.*;
import java.util.*;

public class Main {
    public static int N, M ,res, c_cnt;
    public static int[][] arr;
    public static int[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static ArrayList<int[]> chicken;
    public static ArrayList<int[]> select;
    public static Queue<int []> q;

    public static void dfs(int idx, int cnt){
        if(cnt == M)
        {
            visited = new int[N][N];

            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++)
                {
                    visited[i][j] = -1;
                }
            }
            for(int i =0; i< select.size(); i ++){
                int[] now = select.get(i);
                visited[now[0]][now[1]] ++;
                q.add(new int[] {now[0],now[1]});
            }
            bfs();
            return;
        }
        if(idx >=c_cnt)
            return;

        select.add(chicken.get(idx));
        dfs(idx + 1, cnt + 1);
        select.remove(select.size() - 1);
        dfs(idx + 1, cnt);
    }

    public static void bfs(){
        int sum = 0;
        while(!q.isEmpty())
        {
            int[] now = q.poll();

            for(int d = 0; d<4;d++)
            {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx>=N || ny <0 || ny >=N) continue;
                if(visited[nx][ny]==-1){
                    if(arr[nx][ny] == 1){
                        sum += visited[now[0]][now[1]]+1;
                    }
                    visited[nx][ny] = visited[now[0]][now[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        res = res < sum ?res : sum;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        c_cnt = 0;
        res = Integer.MAX_VALUE;
        arr = new int[N][N];
        chicken = new ArrayList<>();
        select = new ArrayList<>();
        q = new ArrayDeque<>();

        for(int i =0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    chicken.add(new int[]{i,j});
                    c_cnt++;
                }
            }
        }

        dfs(0,0);

        System.out.println(res);

    }
}
