import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][][] visited;
	
	public static void bfs(int i, int j) {
		Queue< int[]> q = new ArrayDeque<int[]>();
		visited[0][i][j]++;
		q.add(new int[] {0,i,j});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[1]==N-1 && now[2] == M-1) {
				int res =visited[0][now[1]][now[2]]==0?visited[1][now[1]][now[2]]:visited[0][now[1]][now[2]];
				System.out.println(res);
				return;
			}
			for(int d =0;d<4 ;d++) {
				int nx = now[1] + dx[d];
				int ny = now[2] + dy[d];
				
				if (nx<0|| nx>=N || ny<0 || ny>=M ) {
					continue;
				}
				
				if(arr[nx][ny]==0) {
					if(now[0]==0 && visited[0][nx][ny]==0) {
						visited[0][nx][ny] = visited[0][now[1]][now[2]]+1;
						q.add(new int[] {0,nx,ny});
					}
					else if(now[0]==1&& visited[1][nx][ny]==0) {
						visited[1][nx][ny] = visited[1][now[1]][now[2]]+1;
						q.add(new int[] {1,nx,ny});
						
					}
				}
				else {
					if(now[0]==0) {
						visited[1][nx][ny] = visited[0][now[1]][now[2]]+1;
						q.add(new int[] {1,nx,ny});
						
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new int[2][N][M]; // 방문 체크, 벽부수고 안부순거리따로 관리 
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M ; j++) {
				arr[i][j] = str.charAt(j) -'0';
			}
		}
		bfs(0,0);


	}

}

