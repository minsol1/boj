import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int str1_len = str1.length();
        int str2_len = str2.length();

        int[][] dp = new int[str1_len+1][str2_len+1];
        StringBuilder sb = new StringBuilder();
        int res = 0;

        for(int i =1 ; i< str1_len+1 ; i++){
            for(int j =1; j < str2_len+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = dp[i-1][j]> dp[i][j-1]?dp[i-1][j]: dp[i][j-1];
                }
            }
        }

        int i = str1_len;
        int j = str2_len;

        while(true){
            if(dp[i][j]==0){
                break;
            }

            if(dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1]){
                sb.append(str2.charAt(j-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] == dp[i][j]){
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]){
                j--;

            }
        }

        System.out.println(dp[str1_len][str2_len]);
        System.out.println(sb.reverse());
    }
}
