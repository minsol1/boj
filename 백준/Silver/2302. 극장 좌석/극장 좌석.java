import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        for(int i =0;i<M;i++){
            int n = Integer.parseInt(br.readLine());
            hs.add(n);
        }
        dp[0]=1;
        dp[1]=1;

        for(int i =2;i<N+1;i++){
            if(hs.contains(i)|| hs.contains(i-1)){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-1]+dp[i-2];

        }
        System.out.println(dp[N]);

    }
}
