import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N];
        int[][][] dp = new int[3][N][3];
        int maxValue =1000000;
        int res = maxValue;

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<N;i++){
            if(i==0){
                for(int j =0;j<3;j++){
                    dp[0][i][j] = maxValue;
                    dp[1][i][j] = maxValue;
                    dp[2][i][j] = maxValue;
                }
                dp[0][i][0] = arr[0][0];
                dp[1][i][1] = arr[1][0];
                dp[2][i][2] = arr[2][0];
            }
            else if(i==N-1){
                for(int j =0;j<3;j++){
                    if(j==0){
                        dp[j][i][1] = Math.min(dp[1][i-1][1],dp[2][i-1][1])+ arr[j][i];
                        dp[j][i][2] = Math.min(dp[1][i-1][2],dp[2][i-1][2])+ arr[j][i];
                        res = res< Math.min(dp[j][i][1],dp[j][i][2])? res: Math.min(dp[j][i][1],dp[j][i][2]);
                    }
                    else if(j==1){
                        dp[j][i][0] = Math.min(dp[0][i-1][0],dp[2][i-1][0])+ arr[j][i];
                        dp[j][i][2] = Math.min(dp[0][i-1][2],dp[2][i-1][2])+ arr[j][i];
                        res = res< Math.min(dp[j][i][0],dp[j][i][2])? res: Math.min(dp[j][i][0],dp[j][i][2]);
                    }
                    else{
                        dp[j][i][1] = Math.min(dp[1][i-1][1],dp[0][i-1][1])+ arr[j][i];
                        dp[j][i][0] = Math.min(dp[1][i-1][0],dp[0][i-1][0])+ arr[j][i];
                        res = res< Math.min(dp[j][i][0],dp[j][i][1])? res: Math.min(dp[j][i][0],dp[j][i][1]);
                    }
                }
            }
            else{
                for(int j =0;j<3;j++){
                    if(j==0){
                        dp[j][i][0] = Math.min(dp[1][i-1][0],dp[2][i-1][0]) + arr[j][i];
                        dp[j][i][1] = Math.min(dp[1][i-1][1],dp[2][i-1][1])+ arr[j][i];
                        dp[j][i][2] = Math.min(dp[1][i-1][2],dp[2][i-1][2])+ arr[j][i];
                    }
                    else if(j==1){
                        dp[j][i][0] = Math.min(dp[0][i-1][0],dp[2][i-1][0])+ arr[j][i];
                        dp[j][i][1] = Math.min(dp[0][i-1][1],dp[2][i-1][1])+ arr[j][i];
                        dp[j][i][2] = Math.min(dp[0][i-1][2],dp[2][i-1][2])+ arr[j][i];
                    }
                    else{
                        dp[j][i][0] = Math.min(dp[1][i-1][0],dp[0][i-1][0])+ arr[j][i];
                        dp[j][i][1] = Math.min(dp[1][i-1][1],dp[0][i-1][1])+ arr[j][i];
                        dp[j][i][2] = Math.min(dp[1][i-1][2],dp[0][i-1][2])+ arr[j][i];
                    }

                }
            }
        }

        System.out.println(res);

    }
}
