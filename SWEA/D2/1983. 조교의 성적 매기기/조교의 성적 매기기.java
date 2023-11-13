import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] s = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double k_score;
			double[] score = new double[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int m =Integer.parseInt(st.nextToken());
				int f =Integer.parseInt(st.nextToken());
				int h =Integer.parseInt(st.nextToken());
				score[i] = m*0.35 + f*0.45 + h*0.2; 
			}
			k_score = score[K-1];
			
			Arrays.sort(score);
			
			for(int i=0;i<N;i++) {
				if(score[N-1-i]==k_score) {
					System.out.println("#"+test_case+" "+s[i/(N/10)]);
					break;
				}
			}

		}
	}
}
