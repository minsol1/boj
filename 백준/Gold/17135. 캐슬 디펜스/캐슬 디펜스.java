import java.io.*;
import java.util.*;

public class Main {

    public static int N,M,D,total;
    public static int[][] arr;
    public static int[][] map;
    public static int[][] visited;
    public static int res;
    public static int [] dx = {0,-1,0};
    public static int [] dy = {-1,0,1};
    public static Queue<int[]> q;

    public static void dfs(int idx, int cnt){
        if(idx == M && cnt == 3){
            atack();
            return;
        }
        if(cnt>3 || idx >=M) return;

        arr[N][idx] = -2;
        dfs(idx+1,cnt+1);
        arr[N][idx] = -1;
        dfs(idx+1,cnt);

    }

    public static void atack(){
        int cnt = 0;// 죽인 적
        int remain = total;
        map = new int[N+1][M];
        for(int i =0;i<N+1;i++){
            for(int j =0;j<M;j++){
                map[i][j] = arr[i][j];
            }
        }

        while(remain>0){

            q = new ArrayDeque<>(); // 죽은 적 위치
            for(int i =0;i<M;i++){
                if(map[N][i]==-2) {
                    visited = new int[N+1][M];
                    bfs(N,i);
                }
            }
            for(int[] pos : q){
                if(map[pos[0]][pos[1]] ==1){
                    map[pos[0]][pos[1]] = 0;
                    cnt++;
                    remain--;
                }
            }
            for(int i =N-1; i>=0;i--){
                for(int j = 0 ; j<M;j++){
                    if(map[i][j]== 1){
                        map[i][j]= 0;
                        if(i == N-1) remain --;
                        else map[i+1][j]= 1;
                    }
                }
            }
        }
        res = res > cnt ? res : cnt;

    }

    public static void bfs(int x, int y){
        Queue<int[]> q2 = new ArrayDeque<>();
        q2.add(new int[]{x,y});

        while(!q2.isEmpty()){
            int[] now = q2.poll();

            if(map[now[0]][now[1]] == 1){
                q.add(new int[]{now[0],now[1]});
                return;
            }

            for(int d = 0;d <3;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx<N+1 && nx>=0 && ny <M && ny>=0 && visited[nx][ny]==0){
                    visited[nx][ny] = visited[now[0]][now[1]]+1;
                    if(visited[nx][ny]<=D) q2.add(new int[]{nx,ny});
                }
            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M];
        total = 0;

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) total++;
            }
        }
        for(int j = 0;j<M;j++){
            arr[N][j] = -1;
        }

        dfs(0,0);

        System.out.println(res);
    }
}
