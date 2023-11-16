import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int cnt =0;
			
			String find = br.readLine();
			String str = br.readLine();
			
			
			while(str.indexOf(find)!=-1) {
				cnt++;
				str = str.replaceFirst(find, "");
			}
			System.out.println("#"+test_case+" "+cnt);
			
		}
	}
}
