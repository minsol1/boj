import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt;
	static int arr[];
	static boolean[] s;
	static boolean[] e;
	
	static void dfs(int x) {
		s[x] = true;
		
		if(!s[arr[x]]) {
			s[arr[x]] = true;
			dfs(arr[x]);
		}
		else {
			if(!e[arr[x]]) {
				int n = arr[x];
				while(true) {
					if(!e[n]) {
						cnt++;
						e[n]= true;
						n = arr[n];
					}
					else {
						break;
					}
					
				}
			}
		}
		
		e[x] = true;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int T = 0; T<t;T++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			s = new boolean[N+1];
			e = new boolean[N+1];
			cnt=0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<N+1;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i<N+1;i++) {
				dfs(i);
			}
			
			System.out.println(N-cnt);
			
		}

	}

}
