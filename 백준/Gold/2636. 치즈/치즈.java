//치즈 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int res,time;
	static int cnt;
	 
	static void bfs() {
		Queue<int[]> q  = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		visited = new boolean[N][M];
		visited[0][0] = true;
		int c =0;
		time++;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d = 0;d<4 ;d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) {
					continue;
				}
				if(arr[nx][ny]==0) { // 공기면 방문
					q.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}else { // 치즈 녹임
					visited[nx][ny] = true;
					arr[nx][ny] =0;
					c++;
				}
			}
		}
		
		cnt -= c;
		
		if( cnt ==0) {
			res = c;
			return;
		}
		else {
			bfs();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cnt =0;
		time = 0;
		
		for(int i =0;i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M ;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		bfs();
		System.out.println(time);
		System.out.println(res);
		
	}

}
