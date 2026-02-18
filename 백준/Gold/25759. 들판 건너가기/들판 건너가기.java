
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        int[] dp= new int[101];
        Arrays.fill(dp, -1);
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer (br.readLine());
        int res  =0;
        dp[Integer.parseInt(st.nextToken())] = 0;

        for(int i =1; i< N; i++){
            int n = Integer.parseInt( st.nextToken());

            for(int j = 1; j <101 ; j++ ){
                if(dp[j] == -1) continue;
                dp[n] = Math.max(dp[n], dp[j]+ (n-j)*(n-j) );
                res = res > dp[n] ? res :dp[n];
            }
        }

        System.out.println(res);
    }
}
