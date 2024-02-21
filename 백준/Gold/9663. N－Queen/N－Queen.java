
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N queen 
public class Main {
	static int N,res;
	static int[] arr;
	
	static void dfs(int n) {
		if(n==N) {
			res++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[n] = i;
			
			if(ispossible(n)) {
				dfs(n+1);
			}
		}
	}

	static boolean ispossible(int n) {
		
		for(int i=0;i<n;i++) {
			if(arr[i]==arr[n]) {
				return false;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(n-i == Math.abs(arr[i]-arr[n])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res =0; 
		
		dfs(0);
		
		System.out.println(res);

	}

}
