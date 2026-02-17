
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            dp[n] = -1;
        }

        int cnt = 0;
        int lastIdx = N;
        for(int i =0; i< N+1; i++){
            if(dp[i]==-1) cnt++;
            else cnt = 0;

            if(cnt == K) {
                lastIdx = i - K;
                break;
            }
        }

        for(int i = lastIdx ; i>0 ; i--){
            if(dp[i] == -1) continue;
            int n = 1;
            for(int j = 1; j< K+1; j++){
                if(j+i > N) break;
                if(dp[i+j] == 1) n = 0;
            }
            dp[i] = n;
        }

        int res = 0;
        for(int i = 1; i <= K ; i++){
            if (i > N) break;
            if(dp[i]== 1) res = 1;
        }
        System.out.println(res);
    }
}
