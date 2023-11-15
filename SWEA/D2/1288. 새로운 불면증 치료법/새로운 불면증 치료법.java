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
			boolean[] num = new boolean[10];
			int k =0;
			
			while(true) {
				k++;
				String n =String.valueOf(k*N);
				
				for(int i=0;i<n.length();i++) {
					num[n.charAt(i)-'0'] = true;
				}
				
				if(exh(num)) break;
			}
			
			System.out.println("#"+test_case+" "+k*N);
		}
	}
	public static boolean exh(boolean[] num) {
		for(int i=0; i<num.length;i++) {
			if(!num[i]) return false;
		}
		return true;
	}
}
