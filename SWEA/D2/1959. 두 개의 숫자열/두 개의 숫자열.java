import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			int max =0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N ;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M ;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i< Math.abs(M-N)+1;i++) {
				int sum=0;
				for(int j =0;j< Math.min(M, N);j++) {
					if(A.length < B.length) {
						sum+=(A[j]*B[i+j]);
					}
					else
						sum+=(A[i+j]*B[j]);
				}
				max = Math.max(max,sum);
			}
			
			System.out.println("#"+test_case+" "+max);
		}
	}
}
