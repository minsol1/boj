import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int wcnt;
	static int bcnt;
	static int[][] arr;
	
	static void cnt(int x,int y,int n) {
		int cnt=0;
		for(int i=x; i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				cnt+=arr[i][j];
			}
		}
		if(cnt==0) {
			wcnt++;
		}
		else if(cnt== n*n) {
			bcnt++;
		}
		else {
			cnt(x, y, n/2);
			cnt(x, y+n/2, n/2);
			cnt(x+n/2, y, n/2);
			cnt(x+n/2, y+n/2, n/2);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		wcnt =0;
		bcnt=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt(0,0,N);
		System.out.println(wcnt);
		System.out.println(bcnt);
		
		
	}
}
