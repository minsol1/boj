import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//벽뿌4 
public class Main {
	static int N,M,c;
	static int[][] arr;
	static ArrayList<Integer> cnt;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();
	static void bfs(int x, int y,int dep) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		c++;
		arr[x][y] = dep;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d =0;d<4 ;d++) {
				int nx = now[0] +dx[d];
				int ny = now[1] +dy[d];
				
				if(nx<0|| nx>=N || ny<0 || ny>=M ) {
					continue;
				}
				
				if(arr[nx][ny]==0) {
					c++;
					arr[nx][ny]= dep;
					q.add(new int[] {nx,ny});
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		int[][] res = new int[N][M];
		Set<Integer> set = new HashSet<>();
		cnt = new ArrayList<>();
		cnt.add(0);
		cnt.add(0);
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0; j<M ; j++) {
				arr[i][j] = str.charAt(j) - '0';
				res[i][j] = str.charAt(j) - '0';
			}
		}
		int dep= 2;
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ; j++) {
				if(arr[i][j]==0) { // 아직 방문 전, 0 
					c =0;
					bfs(i,j,dep++);
					cnt.add(c);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ; j++) {
				
				if(res[i][j] ==1) {
					for(int d =0;d<4 ;d++) {
						int nx = i +dx[d];
						int ny = j +dy[d];
						
						if(nx<0|| nx>=N || ny<0 || ny>=M ) {
							continue;
						}
						if(res[nx][ny]!=1) {
							set.add(arr[nx][ny]);
							
						}
					}
					
					for( int s : set) {
						res[i][j]+=cnt.get(s);
						
					}
					res[i][j]%=10;
					set.clear();
				}
				sb.append(res[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}

