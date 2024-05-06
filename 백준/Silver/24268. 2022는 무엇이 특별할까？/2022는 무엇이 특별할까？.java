
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N , d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int maxValue =0;
		
		for(int i = d-1; i>=0;i--) {
			maxValue += i *Math.pow(d, i);
		}
		
		if(N >= maxValue) {
			System.out.println(-1);
		}
		
		else {
			int[] arr =new int[d]; 
			for(int i =0 ; i<d; i++) {
				arr[i] = i;
			}
			while(true) {
				int i = d-1;
				while ( i>0 && arr[i] <= arr[i-1]) i--;
				
				int j = d-1;
				while(arr[i-1]>= arr[j]) --j;
				
				swap(arr, i-1, j);
				
				int k = d-1;
				
				while(i<k) {
					swap(arr, i++,k --);
				}
				
				int res =0;
				
				for(int r =0;r<d;r++) {
					res += arr[r] * Math.pow(d, d-r-1);
				}
				if(res > N && arr[0]!= 0) {
					System.out.println(res);
					break;
				}
			}
		}
	}
	
	static void swap (int[] arr, int i, int j ) {
		int temp = arr [ i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
