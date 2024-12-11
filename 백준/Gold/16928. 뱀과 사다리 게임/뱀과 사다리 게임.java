import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] arr;
    public static int[] visited;

    public static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start]++;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            if(now ==100){
                return;
            }

            for(int i =1;i<=6;i++){
                int nx = arr[now]+i;

                if(nx<=100&& visited[nx]==-1){
                    q.add(nx);
                    visited[nx] = visited[now]+1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited=new int[101];
        arr = new int[101];

        for(int i =0; i<101;i++){
            visited[i] = -1;
            arr[i]=i;
        }

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        bfs(1);

        System.out.println(visited[100]);
    }
}
