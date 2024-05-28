import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M, size;
	public static StringBuilder sb;
	public static int[] arr = new int[10001];
	
	public static void dfs(int cnt, String temp) {
		if(cnt==M) {
			sb.append(temp).append("\n");
			return;
		}
		
		for(int i = 1; i<size+1;i++) {
			if(arr[i]>0) {
				arr[i]--;
				dfs(cnt+1,temp+i+" ");
				arr[i]++;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size =0;
		
		sb= new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[n]++;
			if (n>size) {
				size=n;
			}
		}
		
		dfs(0,"");
		
		System.out.println(sb);

	}

}
