import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb;
	
	public static void dfs(int idx, int cnt, String temp) {
		if(cnt==M) {
			sb.append(temp).append("\n");
			return;
		}
		
		for(int i = idx; i<N;i++) {
			dfs(i, cnt+1,temp+arr[i]+" ");
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sb= new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0,0,"");
		
		System.out.println(sb);

	}

}
