import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	static int[][] arr;
	static int[] c;
	
	static int[][] r1() {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ;j++) {
				temp[i][j] = arr[N-i-1][j];
				
			}
		}
		
		return temp;
	}
	
	static int[][] r2() {
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ;j++) {
				temp[i][j] = arr[i][M-j-1];
				
			}
		}
		
		return temp;
	}
	
	static int[][] r3() {
		int t = N;
		N = M;
		M = t;
		
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M ;j++) {
				temp[i][j] = arr[M-j-1][i];
			}
		}
		
		return temp;
		
	}
	
	static int[][] r4() {
		int t = N;
		N = M;
		M = t;
		
		int[][] temp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M ;j++) {
				temp[i][j] = arr[j][N-i-1];
			}
		}
		
		return temp;
	}
	
	static int[][] r5() {
		int[][] temp = new int[N][M];
		
		for(int a = 0;a<2;a++) {
			for(int b= 0; b<2 ;b++) {
				
				for(int i=0;i<N/2;i++) {
					for(int j = 0; j<M/2 ;j++) {
						
						if(a==0 && b==0) {
							temp[i][j+ M/2] = arr[i][j];
							
						}
						else if(a==1 && b==1) {
							temp[i+N/2][j] = arr[i+N/2*a][j+ M/2*b];
							
						}else if(a==1) {
							temp[i][j] = arr[i+N/2*a][j+ M/2*b];
							
						}else {
							temp[i+N/2][j+M/2] = arr[i+N/2*a][j+ M/2*b];
							
						}
						
					}
				}
				
			}
		}
		
		return temp;
	}
	
	static int[][] r6() {
		int[][] temp = new int[N][M];
		
		for(int a = 0;a<2;a++) {
			for(int b= 0; b<2 ;b++) {
				
				for(int i=0;i<N/2;i++) {
					for(int j = 0; j<M/2 ;j++) {
						
						if(a==0 && b==0) {
							temp[i+N/2][j] = arr[i][j];
							
						}
						else if(a==1 && b==1) {
							temp[i][j+M/2] = arr[i+N/2*a][j+ M/2*b];
							
						}else if(a==1) {
							temp[i+N/2][j+M/2] = arr[i+N/2*a][j+ M/2*b];
							
						}else {
							temp[i][j] = arr[i+N/2*a][j+ M/2*b];
							
						}
						
					}
				}
				
			}
		}
		
		return temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		c = new int[R];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int c : c) {
			if( c == 1) {
				arr = r1();
			}
			else if(c ==2){
				arr = r2();
			}
			else if (c ==3){
				arr = r3();
			}
			else if(c ==4){
				arr = r4();
			}
			else if(c ==5){
				arr = r5();
			}
			else{
				arr = r6();
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
