
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int max_w=0;
		int res = Integer.MAX_VALUE;

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max_w = max_w > arr[i][1]? max_w :arr[i][1];
		}
	
		int[] dp = new int[C+max_w+1];
		
		for(int i =0;i<N;i++) {
			if(dp[arr[i][1]] ==0) {
				dp[arr[i][1]] = arr[i][0];
			}
			else {
				dp[arr[i][1]] = dp[arr[i][1]]< arr[i][0]?dp[arr[i][1]]:arr[i][0];
			}
			for(int j=0;j<=C;j++) {
				if(dp[j]!=0) {
					if(dp[j+arr[i][1]]==0) {
						dp[j+arr[i][1]] = dp[j] + arr[i][0];
					}else {
						dp[j+arr[i][1]] = dp[j+arr[i][1]]< dp[j]+arr[i][0]?dp[j+arr[i][1]]:dp[j]+arr[i][0];
						
					}
					
				}
			}
		}
		
		for(int i = C ;i<C+max_w+1 ;i++) {
			if(dp[i]!=0) {
				res = res < dp[i]? res : dp[i];
				
			}
		}
		
		System.out.println(res);

	}

}
