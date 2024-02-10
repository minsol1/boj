
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	static boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	static void dfs(int res, int cnt) {
		if(cnt == N ) {
			sb.append(res).append('\n');
			return;
		}
		res *=10;
		
		for(int i=1;i<10;i++) {
			int next = res+i;
			
			if(isPrime(next)) {
				dfs(next,cnt+1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(0,0);
		System.out.print(sb);
		
	}

}
