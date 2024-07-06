import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        int[][][] dp = new int[str1.length()+1][str2.length()+1][str3.length()+1];
        int res = 0;

        for(int i =1;i<str1.length()+1 ; i++){
            for(int j =1 ; j<str2.length()+1;j++){
                for(int k = 1; k<str3.length()+1; k++){
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str1.charAt(i-1) == str3.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                        res = res > dp[i][j][k] ? res : dp[i][j][k];
                    }
                    else{
                        int max = dp[i-1][j][k] > dp[i][j-1][k]?dp[i-1][j][k] : dp[i][j-1][k];
                        max = max> dp[i][j][k-1] ? max:dp[i][j][k-1];

                        dp[i][j][k] = max;

                    }
                }
            }
        }

        System.out.println(res);

    }
}
