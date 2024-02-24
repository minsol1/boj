import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수찾기 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int n = Integer.parseInt(st.nextToken());
			int res = 0;
			int l = 0;
			int r = N-1;
			
			while(r>=l) {
				int m = l+(r-l)/2;
				
				if(arr[m]==n) {
					res = 1;
					break;
				}
				else if(arr[m]<n) {
					l=m+1;
				}
				else {
					r=m-1;
				}
			}
			
			System.out.println(res);
			
		}

	}

}
