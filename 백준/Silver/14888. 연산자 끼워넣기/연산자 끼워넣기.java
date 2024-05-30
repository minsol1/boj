import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N,min, max;
	public static int[] arr;
	public static int[] com;
	
	public static void dfs(int cnt, int temp) {
		if(temp<-1000000000 || temp > 1000000000) {
			return;
		}
		if(cnt == N) {
			min = min<temp?min:temp;
			max = max>temp? max:temp;
			return;
		}
		for(int i =0;i<4;i++) {
			if(com[i]>0) {
				com[i]--;
				if(i==0) {
					dfs(cnt+1,temp+arr[cnt]);
				}else if(i==1) {
					dfs(cnt+1,temp-arr[cnt]);
					
				}else if(i==2) {
					dfs(cnt+1,temp*arr[cnt]);
					
				}else{
					dfs(cnt+1,temp/arr[cnt]);
					
				}
				com[i]++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = -1000000000;
		min = 1000000000;
		arr = new int[N];
		com = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<4;i++) {
			com[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

}
