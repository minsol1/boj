import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static ArrayList<Integer>[] arr;
    public static int[] visited;
    public static int res;

    public static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(Integer n : arr[now]){
                if(visited[n]== -1){
                    visited[n] = visited[now]+1;
                    if(visited[n]<3){
                        res ++;
                        q.add(n);
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        res =0;

        arr=new ArrayList[N+1];
        visited=new int[N+1];
        for(int i=0;i<N+1;i++){
            arr[i] = new ArrayList<>();
            visited[i] =-1;
        }

        StringTokenizer st;
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);

        System.out.println(res);
    }
}
