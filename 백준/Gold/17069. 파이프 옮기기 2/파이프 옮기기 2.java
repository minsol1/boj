import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		long[][][] dp = new long[3][N+1][N+1];
		
		for(int i = 1 ; i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1;j<N+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][2] =1;
		
		for(int i =1;i<N+1;i++) {
			for(int j =3;j<N+1;j++) {
				if(arr[i][j]==0) {
					dp[0][i][j] = dp[0][i][j-1] +dp[1][i][j-1];//가로
					dp[2][i][j] = dp[2][i-1][j] + dp[1][i-1][j]; //세로 
					
					if(arr[i-1][j]!=1&&arr[i][j-1]!=1 ) { // 대각선 
						
						dp[1][i][j] = dp[0][i-1][j-1] +dp[1][i-1][j-1]+dp[2][i-1][j-1];
					}
					
				}
			}
		}
		System.out.print(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);

	}

}
