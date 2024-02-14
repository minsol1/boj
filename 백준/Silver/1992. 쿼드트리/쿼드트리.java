import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;
	static int N;
	
	static void cnt(int x, int y , int n) {
		int cnt =0;
		for(int i=x ; i<x+n ; i++) {
			for(int j=y ; j<y+n ; j++) {
				cnt+= arr[i][j];
			}
		}
		if(cnt==0) {
			System.out.print(0);
			return;
		}else if(cnt== n*n){
			System.out.print(1);
		}
		else {
			System.out.print("(");
			cnt(x, y, n/2);
			cnt(x, y+n/2, n/2);
			cnt(x+n/2, y, n/2);
			cnt(x+n/2, y+n/2, n/2);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0;i<N ;i++) {
			String str = br.readLine();
			for(int j=0;j<N ;j++) {
				arr[i][j] = str.charAt(j) -'0';
			}
		}
		
		cnt(0,0,N);
		
	}

}
