import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 랜선 자르기 
public class Main {
	static int N;
	static int K;
	static int[] arr;
	
	static boolean cnt (int n) {
		int c=0;
		for(int i=0;i<K;i++ ) {
			c+= (arr[i]/n);
		}
		return c>=N;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];

		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int l = 0;
		int r = Integer.MAX_VALUE;
		
		while(r!=l) {
			int m =r-(r-l)/2;
			
			if(cnt(m)) {
				l=m;
				
			}
			else {
				r=m-1;
			}
			
		}
		System.out.println(l);
		
	}

}
