import java.util.*;
import java.io.*;

public class Main {
    public static int N,M,K;
    public static int[] arr;
    public static ArrayList<Integer>[] map;
    public static boolean[] visited;
    public static ArrayList<Integer> child;
    public static ArrayList<Integer> candyCnt;
    public static int[] dp;

    public static void bfs(int x){
        int cnt =0;
        int candy=0;
        visited[x] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        cnt++;
        candy+=arr[x];

        while(!q.isEmpty()){
            int now = q.poll();
            for(int n : map[now]){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                    cnt++;
                    candy+=arr[n];
                }
            }
        }
        child.add(cnt);
        candyCnt.add(candy);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        visited = new boolean[N+1];
        child = new ArrayList<>();
        candyCnt = new ArrayList<>();
        dp = new int[K];
        map = new ArrayList[N+1];

        for(int i =0;i<N+1;i++){
            map[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i =1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        for(int i =1;i<N+1;i++){
            if(!visited[i]){
                bfs(i);
            }
        }

        for(int i =0;i<child.size();i++){
            for(int j = K-1;j>=child.get(i);j--){
                if(dp[j]<dp[j-child.get(i)]+candyCnt.get(i)){
                    dp[j]= dp[j-child.get(i)]+candyCnt.get(i);
                }
            }
        }
        System.out.println(dp[K-1]);
    }
}
