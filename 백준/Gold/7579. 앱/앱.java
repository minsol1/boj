import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] m = new int[N];
        int[] c = new int[N];
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            c[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<N;i++){
            for(int j = 10000; j>= c[i]; j--){
                if(dp[j - c[i]]>=0){
                    dp[j] = dp[j]> dp[j-c[i]]+ m[i] ? dp[j] : dp[j-c[i]]+ m[i];
                }
            }
        }

        for(int i =0; i<10001; i++){
            if(dp[i]>=M) {
                System.out.println(i);
                break;
            }
        }
    }
}
