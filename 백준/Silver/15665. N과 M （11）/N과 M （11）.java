import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M, size;
	public static StringBuilder sb;
	public static int[] arr;
	public static boolean[] isSelected = new boolean[10001];
	
	public static void dfs(int cnt, String temp) {
		if(cnt==M) {
			sb.append(temp).append("\n");
			return;
		}
		
		for(int i = 0; i<size;i++) {
			dfs(cnt+1,temp+arr[i]+" ");
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
			if(!isSelected[n]) {
				size++;
				isSelected[n]=true;
			}
		}
		
		arr = new int[size];
		int idx=0;
		for(int i=0;i<10001;i++) {
			if(isSelected[i]) {
				arr[idx++] = i;
			}
		}
		dfs( 0,"");
		
		System.out.println(sb);

	}

}
