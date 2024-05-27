import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M;
	public static int[] arr;
	public static int[] res;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int idx, int cnt) {
		if(cnt==M) {
			for(int i =0;i<M;i++) {
				System.out.printf("%d ",res[i]);
				
			}
			System.out.println("");
			return;
		}
		
		for(int i = idx; i<N;i++) {
			res[cnt] = arr[i];
			dfs(i+1,cnt+1);
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0,0);

	}

}
