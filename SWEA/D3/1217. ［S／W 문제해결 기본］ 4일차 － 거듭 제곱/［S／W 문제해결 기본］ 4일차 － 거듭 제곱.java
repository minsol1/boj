import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int M;
	public static int N;
	public static int ans;

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			ans =0;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			pow(N,1,0);
			System.out.println("#"+test_case+" "+ans);
			
		}
	}
	
	public static void pow(int n, int m ,int level) {
		if(level==M)  ans =m;
		else pow(n,m*n,level+1);
	}
	
}
