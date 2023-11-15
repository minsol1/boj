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
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[100][100];
			int cnt=0;
			
			for(int i =0; i<100;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j =0; j<100;j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0;j<100;j++) {
				int pre =0;
				for(int i=0;i<100;i++) {
					if(pre ==0&& table[i][j]==1) pre=1;
					else if(pre ==1&& table[i][j]==2) {
						cnt ++;
						pre =2;
					}
					else if(pre ==2&& table[i][j]==1) pre=1;
				}
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}
	}

}
