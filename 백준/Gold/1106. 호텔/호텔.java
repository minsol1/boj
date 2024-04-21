import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int C = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int[] dp = new int[C+101];
		int c, w;
		int maxv = 1000*(C+101);
		int res = maxv;
		for(int i=1 ;i<C+101;i++) {
			dp[i] = maxv;
		}

		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			c = Integer.parseInt(input[0]);
			w = Integer.parseInt(input[1]);
			
			
			for(int j=w;j<=C+100;j++) {
				dp[j] = dp[j]< dp[j-w]+c?dp[j]: dp[j-w]+c;
			}
		}
		
		for(int i = C ;i<C+101 ;i++) {
			res = res < dp[i]? res : dp[i];
		}
		
		System.out.println(res);

	}

}
