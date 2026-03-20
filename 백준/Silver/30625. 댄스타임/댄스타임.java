
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N][2];
        int[][] arr = new int[N][2];
        int D = 1000000007;

        for(int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        if(arr[0][1] == 1){// 뒤
            dp[0][0] = M-1;
            dp[0][1] =1;
        }
        else {// 앞
            dp[0][0] = 1;
            dp[0][1] =M-1;
        }

        for(int i =1; i< N; i++){
            if(arr[i][1] == 1){// 뒤

                dp[i][0] = (dp[i-1][0] * (M-1))%D;
                dp[i][1] = ((dp[i-1][1] * (M-1))%D  + dp[i-1][0])%D ;
            }
            else {// 앞
                dp[i][0] = dp[i-1][0];
                dp[i][1] = (dp[i-1][1]  + (dp[i-1][0] * (M-1))%D )%D;
            }
        }

        System.out.println((dp[N-1][0]+dp[N-1][1])%D);



    }
}
