import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static boolean f;
    public static int[][] pos;
    public static boolean[] visited;

    public static void bfs(){
        visited[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while(!q.isEmpty()){
            int n = q.poll();
            if(n == N+1){
                f = true;
                return;
            }

            for(int nx = 0; nx < N+2; nx++){
                int d = Math.abs(pos[n][0] - pos[nx][0])+Math.abs(pos[n][1] - pos[nx][1]);

                if(d <= 1000 && !visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T;t++){
            N = Integer.parseInt(br.readLine());
            pos = new int[N+2][N+2];
            visited = new boolean[N+2];
            f = false;

            for(int i =0; i<N+2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }
            bfs();

            if(f) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
