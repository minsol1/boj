import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[4][10001];
		int T = Integer.parseInt(br.readLine());
		dp[1][1]=1;
		dp[1][2]=1;
		dp[2][2]=1;
		dp[1][3]=1;
		dp[2][3]=1;
		dp[3][3]=1;
		
		for(int i = 4; i<10001;i++) {
			for(int j = 1; j<=3;j++) {
				for(int k=0;k<=j;k++) {
					dp[j][i]+=dp[k][i-j];
				}
			}
		}
		for(int t = 0; t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[1][n]+dp[2][n]+dp[3][n]);
		}

	}

}
