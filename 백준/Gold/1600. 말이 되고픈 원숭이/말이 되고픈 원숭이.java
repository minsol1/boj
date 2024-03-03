import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말되원 
public class Main {
	static int N,M,K ;
	static int[][] arr;
	static int[] hdx = {-1,-2,-2,-1,1,2,2,1}; 
	static int[] hdy = {-2,-1,1,2,2,1,-1,-2};
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][][] visited;
	
	static class Node{
		int cnt;
		int x;
		int y;
		int len;
		
		public Node(int cnt, int x, int y, int len) {
			super();
			this.cnt = cnt;
			this.x = x;
			this.y = y;
			this.len = len;
		}
		
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.add(new Node(0,0,0,0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if( now.x == N-1 && now.y == M-1) {
				System.out.println(now.len);
				return;
			}
			
			if(now.cnt<K) {
				for(int d = 0; d<8;d++) {
					int nx = now.x + hdx[d];
					int ny = now.y + hdy[d];
					
					if(nx<0 || nx>=N || ny < 0 || ny>=M) {
						continue;
					}
					if(!visited[now.cnt+1][nx][ny] && arr[nx][ny]==0) {
						visited[now.cnt+1][nx][ny] = true;
						q.add(new Node(now.cnt+1,nx,ny,now.len+1));
					}
					
				}
			}
			for(int d=0;d<4;d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(nx<0 || nx>=N || ny < 0 || ny>=M) {
					continue;
				}
				if(!visited[now.cnt][nx][ny] && arr[nx][ny]==0) {
					visited[now.cnt][nx][ny] = true;
					q.add(new Node(now.cnt,nx,ny,now.len+1));
				}
				
			}
		}
		System.out.println(-1);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[K+1][N][M];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		

	}

}
