
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int r;
	static int c;
	static int res;
	
	static void z(int x, int y , int n) {
		
		if(n>1) {
			if(x+n/2<=r &&y+n/2<=c) {
				res += (n/2)*(n/2)*3;
				z(x+n/2, y+n/2 , n/2);
			}
			else if(x+n/2<=r) {
				res += (n/2)*(n/2)*2;
				z(x+n/2, y, n/2);
			}
			else if(y+n/2<=c) {
				res += (n/2)*(n/2)*1;
				z(x, y+n/2 , n/2);
			}
			else {
				z(x, y , n/2);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		res = 0;
		z(0,0,N);
		System.out.println(res);
	}

}
