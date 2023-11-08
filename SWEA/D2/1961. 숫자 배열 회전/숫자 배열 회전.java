import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] res = new int[N][N*3];
			int[][] num = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<3;i++) {
				for(int k=0;k<N;k++) {
					for(int j = 0;j<N;j++) {
						res[k][j+i*N] = num[N-1-j][k];
					}
				}
				for(int k=0;k<N;k++) {
					for(int j = 0;j<N;j++) {
						num[k][j]=res[k][j+i*N];
					}
				}
			}
			System.out.println("#"+test_case );
			for(int i=0;i<N;i++) {
				for(int j =0;j<N*3;j++) {
					if(j%N==0&&j!=0) System.out.print(" ");
					System.out.print(res[i][j]);
				}
				System.out.println("");
			}
		}
	}
}
