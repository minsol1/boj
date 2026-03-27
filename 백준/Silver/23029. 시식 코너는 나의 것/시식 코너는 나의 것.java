
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];

        for(int i = 1; i< N+1; i++){
            int n = Integer.parseInt(br.readLine());
            if(i > 1){
                dp[i][0] =Math.max(dp[i-2][2], Math.max(dp[i-2][0],dp[i-2][1] ))+n;

                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + n/2;

                dp[i][2] = Math.max(dp[i-1][2], Math.max(dp[i-1][0],dp[i-1][1] ));

            }
            else dp[i][0] = n;

        }

        System.out.println(Math.max(dp[N][2], Math.max(dp[N][0],dp[N][1])));
    }
}
