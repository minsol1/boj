import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //가지고 있는 추
        int N = Integer.parseInt(br.readLine());
        int[] chu = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<N+1;i++){
            chu[i] = Integer.parseInt(st.nextToken());
        }

        // 확인할 무게
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][40001];
        dp[0][0] = true;

        for(int i =1 ; i<N+1; i++){
            for(int j =0;j<40001;j++){
                if(j == chu[i]) dp[i][j] = true;

                if(j+chu[i]<40001) dp[i][j] |= dp[i-1][j+chu[i]];

                dp[i][j] |= dp[i-1][Math.abs(j-chu[i])];

                if(dp[i-1][j]){
                    dp[i][j]= true;
                }
            }
        }

        for(int n : arr){
            if(dp[N][n]) System.out.print("Y ");
            else System.out.print("N ");
        }

    }
}
