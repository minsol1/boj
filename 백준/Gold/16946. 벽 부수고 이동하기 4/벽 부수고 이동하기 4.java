import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//벽뿌4 
public class Main {
	static int N,M, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> q1;
	static StringBuilder sb = new StringBuilder();
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		cnt++;
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d =0;d<4 ;d++) {
				int nx = now[0] +dx[d];
				int ny = now[1] +dy[d];
				
				if(nx<0|| nx>=N || ny<0 || ny>=M ) {
					continue;
				}
				
				if(arr[nx][ny]==0&&!visited[nx][ny]) {
					cnt++;
					visited[nx][ny]= true;
					q.add(new int[] {nx,ny});
				}
				else if(arr[nx][ny]!=0&&!visited[nx][ny]) {
					visited[nx][ny] = true;
					q1.add(new int[] {nx,ny});
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

		q1 = new ArrayDeque<>();// 1담을큐 
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0; j<M ; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ; j++) {
				if(!visited[i][j] && arr[i][j]==0) { // 아직 방문 전, 0 
					cnt =0;
					bfs(i,j);
					while(!q1.isEmpty()) {
						int[] n = q1.poll();
						visited[n[0]][n[1]] = false;
						arr[n[0]][n[1]]+=cnt;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j = 0; j<M ; j++) {
				sb.append(arr[i][j]%10);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}

}
