import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {0,0,0,0});
		visited[0][0][0]= true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0] == N-1 && now[1] == M-1) {
				return now[3];
			}
			
			for(int d= 0; d<4;d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				
				if(nx<0 || nx>=N || ny < 0 || ny>=M) {
					continue;
				}
				if(visited[nx][ny][now[2]] || now[3] > T) {
					continue;
				}
				
				if(now[2]==1) {
					q.add(new int[] {nx,ny,now[2],now[3]+1});
					visited[nx][ny][now[2]] = true;
				
				}
				else {
					if(arr[nx][ny] == 0 ) {
						q.add(new int[] {nx,ny,now[2],now[3]+1});
						visited[nx][ny][now[2]] = true;
						
					}
					else if(arr[nx][ny] == 2) {
						q.add(new int[] {nx,ny,1,now[3]+1});
						visited[nx][ny][1] = true;
						visited[nx][ny][0] = true;
						
					}
					
				}
				
			}
		}
		return -1;
		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][2];

		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = bfs();
		
		if(res == -1) {
			System.out.println("Fail");
		}
		else {
			System.out.println(res);
		}
		
	}

}
