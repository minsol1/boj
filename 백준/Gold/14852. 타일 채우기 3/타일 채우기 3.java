import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d =1000000007;
        long[] dp1 = new long[N+1];
        long[] dp2 = new long[N+1];
        dp1[0] = 1;
        dp2[0] = 1;
        dp1[1] = 2;
        dp2[1] = 2;

        for(int i = 2 ; i<=N; i++){
            dp2[i] += (((dp1[i-1]*2 %d) + dp2[i-1])%d);
            dp2[i]%=d;
            dp1[i] += ((dp2[i] + dp1[i-2])%d);
            dp1[i]%=d;
        }

        System.out.println(dp1[N]);

    }
}
