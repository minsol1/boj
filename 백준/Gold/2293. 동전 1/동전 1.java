import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[K+1];
		int c=0;
		
		for(int i = 0 ;i<N;i++) {
			c = Integer.parseInt(br.readLine());
			if(c>K) {
				continue;
			}
			
			dp[c]++;
			for(int j = c+1 ; j<K+1 ; j++) {
				dp[j]+= dp[j-c];
			}
		}
		System.out.println(dp[K]);
	}

}
