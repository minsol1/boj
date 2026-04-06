
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< N; i++){
            dp[i] = 1;
            for(int j = i-1; j >=0; j--){
                if(arr[j] < arr[i]){
                    dp[i]=  (dp[i] + dp[j]) % 998244353;
                }
            }
            System.out.print(dp[i] +" ");
        }


    }
}
