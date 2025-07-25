import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        int[] cnt = new int[N+1];
        ArrayList[] arr = new ArrayList[N+1];
        for(int i =0; i<N+1;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre =Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                cnt[a]++;
                arr[pre].add(a);
                pre = a;

            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =1; i<N+1; i++){
            if(cnt[i]==0){
                q.add(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            sb.append(now).append('\n');
            for(int i =0;i<arr[now].size();i++){
                int nxt = (int)arr[now].get(i);
                cnt[nxt] --;
                if(cnt[nxt] == 0) q.add(nxt);
            }
        }
        for(int i =1;i<N+1;i++){
            if(!visited[i]){
                sb = new StringBuilder();
                sb.append(0);
            }
        }

        System.out.println(sb);
    }
}
