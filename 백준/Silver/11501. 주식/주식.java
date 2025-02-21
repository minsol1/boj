import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0 ; t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            long res = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =N-2 ; i>=0; i--){
                dp[i] = dp[i+1] > arr[i+1] ? dp[i+1] : arr[i+1];
            }
            for(int i =0;i<N;i++){
                if(dp[i]-arr[i]>0){
                    res += (dp[i]-arr[i]);
                }
            }
            sb.append(res).append('\n');

        }
        System.out.println(sb);
    }
}
