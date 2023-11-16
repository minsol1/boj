import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			int a =0;
			int b =0;
			int c =0;
			int d =0;
			int e =0;
			
			while(N!=1) {
				if(N%2==0) {
					a++;
					N/=2;
				}
				if(N%3==0) {
					b++;
					N/=3;
				}
				if(N%5==0) {
					c++;
					N/=5;
				}
				if(N%7==0) {
					d++;
					N/=7;
				}
				if(N%11==0) {
					e++;
					N/=11;
				}
			}
			System.out.println("#"+test_case+" "+a+" "+b+" "+c+" "+d+" "+e);
		}
	}
}
