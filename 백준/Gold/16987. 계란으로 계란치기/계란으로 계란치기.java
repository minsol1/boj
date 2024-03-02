import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,res;
	static int[][] arr;
	
	static void dfs(int idx, int cnt) {
		if(idx == N) {
			res = Math.max(res, cnt);
			return;
		}
		if(arr[idx][0]<=0) {
			dfs(idx+1 , cnt);
		}
		else {
			int c=0;
			for(int i=0;i<N;i++) {
				if(arr[i][0]>0&& i!=idx) {
					c++;
				}
			}
			if(c==0) {
				dfs(idx+1, cnt);
			}
			else {
				for(int i =0;i<N;i++) {
					if(arr[i][0]>0 && i!=idx) {
						arr[idx][0] -= arr[i][1];
						arr[i][0] -= arr[idx][1];
						c=0;
						c = arr[idx][0]<=0? c+1 :c;
						c = arr[i][0]<=0? c+1 :c;
						dfs(idx+1, cnt+c);
						arr[idx][0] += arr[i][1];
						arr[i][0] += arr[idx][1];
						
					}
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		res = 0;

		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		System.out.println(res);
	}

}
