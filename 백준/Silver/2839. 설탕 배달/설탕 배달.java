import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		
		Arrays.fill(dp, -1);
		dp[3]=1;
		dp[5]=1;
		
		for(int i=6;i<N+1;i++) {
			if ((dp[i-3]!=-1) && (dp[i-5]!=-1)){
				dp[i]= (dp[i-3]<dp[i-5])?dp[i-3]+1 :dp[i-5]+1; 
			}
			else if (dp[i-5] !=-1) {
				dp[i]=dp[i-5]+1;
			}
			else if (dp[i-3] !=-1) {
				dp[i]=dp[i-3]+1;
			}
		}
		
		System.out.println(dp[N]);
		

	}

}