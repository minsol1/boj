import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int len = Integer.parseInt(br.readLine());
			String[][] str = new String[8][8];
			int ans =0;
			
			for(int i=0 ; i<8;i++) {
				String line= br.readLine();
				str[i] = line.split("");
			}

		
			for(int i=0;i<9-len;i++) {
				for(int j = 0 ;j<8 ; j++) {
					boolean t =true;
					
					for(int k=0;k<len/2;k++) {
						if(!str[i+k][j].equals(str[i+len-k-1][j])) t = false;
					}
					if(t) ans++;
				}
			}
			for(int j=0;j<9-len;j++) {
				for(int i = 0 ;i<8 ; i++) {
					boolean t =true;
					for(int k=0;k<len/2;k++) {
						if(!str[i][j+k].equals(str[i][j+len-k-1])) t = false;
					}
					if(t) ans++;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
		
	}
}
