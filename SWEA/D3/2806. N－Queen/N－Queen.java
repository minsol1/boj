import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static int ans;
	public static int N;
	

	public static void main(String args[]) throws Exception
	{
	//	System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			int[] row = new int[N];
			
			ans =0;
			
			dfs(0,row);
			
			System.out.println("#"+test_case+" "+ans);
		}
		
	}
	
	public static void dfs(int level, int[] row) {
		if(level == N) {
			ans++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			row[level] = i;
			
			if(isPromising(level,row)) {
				dfs(level+1,row);
			}
		}
	}
	public static boolean isPromising(int next, int[] row) {
		for(int i =0;i<next;i++) {
			if(row[i]==row[next] || Math.abs(row[i]-row[next])==next-i) return false;
		}
		return true;
	}
}
