import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static int max=0;
	public static int N;
	public static int L;

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max=0;
			int[][] m = new int[N][2];
			
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				m[i][0] = Integer.parseInt(st.nextToken());
				m[i][1] = Integer.parseInt(st.nextToken());
			}
			cho(m,0,0,0);
			
			System.out.println("#"+test_case+" "+max);
			
		}
	}
	
	public static void cho(int[][] m , int l,int t_sum,int c_sum) {
		if(c_sum > L ) return;
		if(l==N) {
			max = Math.max(max, t_sum);
			return;
		}
		
		cho(m,l+1,t_sum+m[l][0],c_sum+m[l][1]);
		cho(m,l+1,t_sum,c_sum);
	}
}
