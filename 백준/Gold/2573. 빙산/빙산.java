import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M, cnt;
	public static int[][] arr;
	public static int res;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static boolean[][] visited = new boolean[N][M];
	public static Queue<int[]> q1;
	
	public static void bfs1(int i, int j ) {
		q1.add(new int[] {i,j});
		visited[i][j]= true;
		
		while(!q1.isEmpty()) {
			int[] now = q1.poll();
			int x = now[0];
			int y = now[1];
			
			for(int d = 0; d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!visited[nx][ny] && arr[nx][ny] !=0) {
					visited[nx][ny] = true;
					q1.add(new int[] {nx,ny});
				}
			}
		}
		
	}
	
	public static void bfs2() {
		int[][] c = new int[N][M];
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]!=0) {
					q1.add(new int[] {i,j});
				}
			}
		}
		
		while(!q1.isEmpty()) {
			int[] now = q1.poll();
			int x = now[0];
			int y = now[1];
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(arr[nx][ny]==0) {
					c[x][y]++;
				}
			}
			
		}
		
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				arr[i][j]-=c[i][j];
				if(arr[i][j]<0) {
					arr[i][j]=0;
				}
//				arr[i][j] = arr[i][j]<0?0:arr[i][j];
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = 0;
		
		arr= new int[N][M];
		q1 = new ArrayDeque<int[]>();
		
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j]!=0 && !visited[i][j]) {
					bfs1(i,j);
					cnt++;
				}
			}
		}
		
		while(cnt < 2 && cnt != 0) {
			res++;
			
			bfs2();
			
			cnt =0;
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j]!=0 && !visited[i][j]) {
						bfs1(i,j);
						cnt++;
					}
				}
			}
		}
		
		if(cnt < 2) {
			res=0;
		}
		
		System.out.println(res);

	}

}
