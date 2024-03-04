import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//월드컵 
public class Main {
	static int N=6;
	static int[][] arr;
	static boolean end;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int cur, int idx) {
		if(end) {
			return;
		}
		
		if(idx ==N) {
			cur++;
			idx =cur+1;
		}
		
		if(cur==N-1 && idx==N) {
			end = true;
			return;
		}

	    //cur 이 이긴 경우 
	    if(arr[cur][0]>0 && arr[idx][2]>0) {
	       arr[cur][0] --;
	       arr[idx][2]--;
	       dfs(cur, idx+1);
	       arr[cur][0] ++;
	       arr[idx][2]++;
	
	    }
	    // cur 무승부 
	
	    if(arr[cur][1]>0 && arr[idx][1]>0) {
	       arr[cur][1] --;
	       arr[idx][1]--;
	       dfs(cur, idx+1);
	       arr[cur][1] ++;
	       arr[idx][1]++;
	    }
	    
	    // cur 짐
	    if(arr[cur][2]>0 && arr[idx][0]>0) {
		       arr[cur][2] --;
		       arr[idx][0]--;
		       dfs(cur, idx+1);
		       arr[cur][2] ++;
		       arr[idx][0]++;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[N][3]; 
			end = false;
			boolean f = true;
			
			for(int i = 0; i<6;i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
				
				if(arr[i][0]+arr[i][1]+arr[i][2] !=5) {
					f = false;
				}
			}
			if(f) {
				dfs(0,1);
			}
			if(end) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
			
		}
		
		System.out.println(sb);
	}

}
