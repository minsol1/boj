import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N+1];
        StringBuilder sb = new StringBuilder();
        ArrayList[] arr = new ArrayList[N+1];

        for(int i =0;i<N+1;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cnt[b]++;
            arr[a].add(b);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i =1; i<N+1;i++){
            if(cnt[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            
            for(int i =0;i<arr[now].size();i++){
                int n = (int)arr[now].get(i);
                cnt[n]--;
                if(cnt[n]==0) q.add(n);
            }
        }
        System.out.println(sb);

    }
}
