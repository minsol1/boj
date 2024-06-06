import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] arr;
	public static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[26];
		int res = 0;
		
		for(int i=0;i<N;i++) {
			String str =br.readLine();
			int tem = 1;
			for(int j = str.length()-1; j>=0;j--) {
				arr[str.charAt(j)-'A']+=tem;
				tem*=10;
			}
		}
		
		
		Arrays.sort(arr);
		int n = 9;
		for(int i = 25; i>=0; i--) {
			res += arr[i]*n;
			n--;
		}
		System.out.println(res);
				
	}

}
