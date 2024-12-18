import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] cost = new int[N];

        for(int i = 1; i<K+1;i++){
            dp[i] = 10001;
        }

        for(int i =0; i<N;i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        for(int i =1; i<K+1;i++){
           for(int j = 0;j<N;j++){
                if(i>=cost[j]){
                    dp[i] = dp[i]<dp[i-cost[j]]+1?dp[i]:dp[i-cost[j]]+1;
                }
            }
        }

        if(dp[K]==10001){
            System.out.print(-1);
        }else{
            System.out.print(dp[K]);
        }
    }
}
