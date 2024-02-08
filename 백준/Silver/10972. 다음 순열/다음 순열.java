
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s=N-1;
		while (s>0 &&arr[s-1] > arr[s]) {
			s--;
		}
		if(s==0) {
			System.out.println(-1);
		}
		else {
			
			int e = N-1;
			while(e>s && arr[s-1] > arr[e]) {
				e--;
			}
			
			int temp = arr[s-1];
			arr[s-1] = arr[e];
			arr[e] = temp;
			
			Arrays.sort(arr,s,N);
			
			for(int i=0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
			
		}

	}

}
