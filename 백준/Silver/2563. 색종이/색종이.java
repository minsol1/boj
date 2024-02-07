import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		boolean[][] arr = new boolean[100+1][100+1];

		int res = 0;
		
		int[][] p = new int[N][2]; // 색종이 위치 정보 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for(int j = s;j<s+10;j++) {
				for(int k =e ; k<e+10 ; k++) {
					if(!arr[j][k]) {
						arr[j][k]=true;
						res++;
					}
				}
			}
		}
		
		System.out.println(res);
	}

}
