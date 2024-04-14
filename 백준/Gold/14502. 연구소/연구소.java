
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소 
public class Main {
	static int N,M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int res=0;
	static int cnt2,cnt1,cnt;
	static Queue<int[]> q = new ArrayDeque<>();
	static Queue<int[]> q2 = new ArrayDeque<>();
	
	static void dfs(int c) {
		
		if (c == 3) {
			cnt=0; // 바이러스 수 
			
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(arr[i][j] == 2) {
						q.add(new int[] {i,j}); // 바이러스 큐에 넣음 
						visited[i][j] = true;// 방문 
						cnt++;
					}
				}
			}
			
			bfs();
			
			while(!q2.isEmpty()) {
				int[] now = q2.poll();
				
				visited[now[0]][now[1]] = false;
			}
			
			return;

		}
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(c+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
//			if(cnt>cnt2) {
//				return;
//			}
			
			for(int d = 0; d<4;d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				
				if(nx < 0 || nx >=N || ny <0 || ny>=M || visited[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					q.add(new int[] {nx,ny});
					q2.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					cnt++;
				}
				
			}
		}
		
		cnt2 = cnt;
		res = res > N*M-cnt2-cnt1 ? res :N*M-cnt2-cnt1;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		cnt2 = N*M; // 바이러스 수 
		cnt1 =0; // 벽 수 
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<M ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j]==1) {
					cnt1++;
				}
			}
		}
		cnt1 +=3;
		
		dfs(0);
		System.out.println(res);

	}

}
