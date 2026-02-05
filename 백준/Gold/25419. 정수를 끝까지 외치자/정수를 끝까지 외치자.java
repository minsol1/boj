
import java.io.*;
import java.util.*;

public class Main {

    public static int N , K;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();

        int [] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = N; i > 0; i--){
            if(hs.contains(i)) continue;
            if(dp[i] == Integer.MAX_VALUE) dp[i] = 1;
            for(int j = 1; j <=K; j++){
                if(i - j > 0 && !hs.contains(i-j)){
                    dp[i-j] = Math.min(dp[i-j], dp[i]+1);
                }
            }
        }
//        for(int i : dp){
//            System.out.print(i+" ");
//        }
//        System.out.println("");

        int res = 0;
        int cnt = 0;
        for(int i = 1; i<=K; i++){
            if(dp[i] == Integer.MAX_VALUE) {
                cnt++;
                continue;
            }
            if(dp[i]%2 == 1) res = 1;
        }
        if(cnt == K) res = 0;

        System.out.println(res);
    }
}
