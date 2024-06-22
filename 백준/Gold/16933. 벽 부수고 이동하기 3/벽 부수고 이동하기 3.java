import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static int N,M,K;
    public static int[][] arr;
    public static boolean[][][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int res = Integer.MAX_VALUE;
    // 홀 -> 낮 짝 -> 밤

    public static void bfs(){
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[] {0,0,0,1});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int k = now[2];
            int dist = now[3];

            if(now[0] == N-1 && now[1] == M-1){
                res = res<dist? res : dist;
                continue;
            }

            for(int d = 0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx<0 || nx >=N || ny<0 || ny >=M || visited[nx][ny][k]){
                    continue;
                }
                if(arr[nx][ny] == 0){
                    visited[nx][ny][k]= true;
                    q.add(new int[]{nx,ny,k,dist+1});
                }
                else{
                    if(k < K && !visited[nx][ny][k+1]){
                        if(dist%2 ==1){ // 이동
                            visited[nx][ny][k+1] = true;
                            q.add(new int[]{nx,ny,k+1,dist+1});

                        }
                        else{ // 머무르기
                            q.add(new int[]{now[0],now[1],k,dist+1});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j =0; j<M;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        bfs();

        res = res==Integer.MAX_VALUE?-1 : res;
        System.out.println(res);

    }
}
