
import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, X, res;
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;

    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        visited[X] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i =0; i< arr[now].size(); i++){
                int next = arr[now].get(i);
                if(!visited[next]){
                    res++;
                    visited[next] = true;
                    q.add(next);
                }
            }

        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;

        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for(int i =0; i< N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i =0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].add(a);
        }

        X = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(res);

    }
}
