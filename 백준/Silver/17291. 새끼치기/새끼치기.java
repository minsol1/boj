import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 1;

        for(int i = 0; i<N+1 ; i++){
            if(i<4){
                for(int j=0;j<i;j++){
                    dp[i]+=dp[j];
                }
            }
            else{
                if(i%2==0){
                    for(int j = i-3 ; j<i;j++){
                    dp[i]+=dp[j];
                    }
                }
                else{
                    for(int j = i-4 ; j<i;j++){
                        dp[i]+=dp[j];
                    }
                }
            }
        }
        System.out.println(dp[N]);
    }
}
