
import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,R;
    public static long res,cnt;
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;

    public static void dfs(int s, long d){
        visited[s] =true;
        cnt++;
        res += cnt*d;

        for(int i =0; i< arr[s].size(); i++){
            int nx = arr[s].get(i);
            if(!visited[nx]){
                dfs(nx, d+1);
            }
        }

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cnt = 0;
        res = 0;

        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for(int i =0; i< N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i =0; i< M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i =0; i< N+1; i++){
            Collections.sort(arr[i]);
            Collections.reverse(arr[i]);
        }

        dfs(R, 0);


        System.out.println(res);
    }
}
