import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[3] = 1;
        if(N>=5) dp[5] =1;

        for(int i =4;i<=N;i++){
            if(dp[i-3]!=Integer.MAX_VALUE) dp[i]= dp[i-3]+1;
            if(i>5 && dp[i-5]!=Integer.MAX_VALUE){
                dp[i]= Math.min(dp[i],dp[i-5]+1);
            }
        }

        if(dp[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N]);

    }
}
