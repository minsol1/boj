import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 추 개수
        int[] arr = new int[N]; // 추
        int sum=0; // 추 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }

        boolean[][] dp = new boolean[N][sum*2+1]; // 만들수있는 경우
        dp[0][arr[0]]  = true;
        dp[0][0] = true;

        for(int i =1; i<N;i++){
            for(int j = 0 ; j<=sum ; j++){
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    dp[i][Math.abs(j - arr[i])]  = true;
                    dp[i][Math.abs(j + arr[i])]  = true;
                }
            }
            dp[i][arr[i]] = true;
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M;i++){
            int a = Integer.parseInt(st.nextToken());
            if(a > sum) {
                System.out.print("N ");
                continue;
            }
            if(dp[N-1][a]) System.out.print("Y ");
            else System.out.print("N ");
        }


    }
}
