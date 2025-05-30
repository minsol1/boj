import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t =0;
        while(true){
            t++;
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] arr = new int[N][3];
            int[][] dp = new int[N][3];
            StringTokenizer st;

            for(int i =0;i<N;i++){
                st= new StringTokenizer(br.readLine());
                for(int j =0;j<3;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1]+arr[0][2];

            for(int i =1;i<N;i++){

                if(i==1){
                    dp[i][0] =dp[i-1][1]+arr[i][0];
                }
                else{
                    dp[i][0] =Math.min( dp[i-1][0], dp[i-1][1])+arr[i][0];
                }

                int min =Integer.MAX_VALUE;
                for(int j =0;j<3;j++){
                    if(i==1&& j==0) continue;
                    min = min<dp[i-1][j]?min:dp[i-1][j];
                }
                dp[i][1] =Math.min( min, dp[i][0])+arr[i][1];


                dp[i][2] =Math.min( dp[i-1][2], dp[i][1]);
                dp[i][2] =Math.min( dp[i][2], dp[i-1][1])+arr[i][2];

            }
            sb.append(t).append(". ").append(dp[N-1][1]).append('\n');
            
        }

        System.out.println(sb);

    }
}
