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
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = Integer.MAX_VALUE;
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int n = Integer.parseInt(st.nextToken());
			int res = 0;
			int l = 0;
			int r = N;
			
			while(r!=l) {
				int m = l+(r-l)/2;
				//System.out.println(m);
				if(arr[m]<n) {
					l=m+1;
				}
				else {
					r=m;
				}
			}
			res = arr[r]==n ? 1:0;
			System.out.println(res);
			
		}

	}

}
