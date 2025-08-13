import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        long[][][] dp = new long[N][N][3];

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;

        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(i ==0 && j ==1)
                    continue;
                if(j>0 && arr[i][j] != 1)
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                if(i>0 && arr[i][j] != 1)
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                if(i>0 && j > 0 && arr[i][j] != 1 && arr[i-1][j] != 1&& arr[i][j-1] != 1)
                    dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];

            }
        }

        System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);

    }
}
