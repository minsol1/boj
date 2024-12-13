import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] dp = new int[2][N];
        int [] one = new int[N];
        int [] two = new int[N];
        int K;

        StringTokenizer st;
        for(int i =0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            one[i] = a;
            two[i] = b;
        }
        K = Integer.parseInt(br.readLine());

        dp[0][0] = 0;
        dp[1][0] = 0;

        for(int i =1; i<N;i++){
            if(i==1){
                //1칸 점프
                dp[0][i] = dp[0][i-1]+ one[i-1];
                dp[1][i] = dp[0][i];
            }
            else if(i==2){
                // 1칸 점프 or 2칸 점프중 최소값
                dp[0][i] = Math.min(dp[0][i-1]+ one[i-1] , dp[0][i-2]+two[i-2]);
                dp[1][i] = dp[0][i];
            }
            else{
                // k점프 x
                dp[0][i] = Math.min(dp[0][i-1]+ one[i-1] , dp[0][i-2]+two[i-2]);

                // k점프 함
                dp[1][i] = dp[0][i-3] + K;
                if(i>=4){
                    dp[1][i] = dp[1][i]<dp[1][i-1] +one[i-1] ?dp[1][i]:dp[1][i-1] +one[i-1];
                }
                if(i>=5){
                    dp[1][i] = dp[1][i]<dp[1][i-2] +two[i-2] ?dp[1][i]:dp[1][i-2] +two[i-2];

                }

            }
        }
        int res = dp[1][N-1] < dp[0][N-1] ?dp[1][N-1] : dp[0][N-1];

        System.out.println(res);

    }
}
