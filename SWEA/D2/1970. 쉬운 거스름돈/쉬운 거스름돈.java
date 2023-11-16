import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N =Integer.parseInt(br.readLine());
			int[] coin = {50000,10000,5000,1000,500,100,50,10};
			int[] cnt = new int[8];
			
			for(int i =0;i<8;i++) {
				cnt[i] = N/coin[i];
				N%=coin[i];
			}
			System.out.println("#"+test_case);
			for(int i=0;i<8;i++) {
				System.out.print(cnt[i]+" ");
			}
			System.out.println("");
			
		}
	}
}
