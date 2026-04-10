
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[H+1]; // 0 키 합 , 젤 느린 사람
        Arrays.fill(dp,-1);
        dp[0] = Integer.MAX_VALUE;

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for(int j = H; j>=h; j--){
                if(dp[j-h] != -1){
                    int m = Math.min(dp[j-h], s);
                    if(dp[j] < m){
                        dp[j] = m;
                    }
                }
            }
        }

        System.out.println(dp[H]);


    }
}
