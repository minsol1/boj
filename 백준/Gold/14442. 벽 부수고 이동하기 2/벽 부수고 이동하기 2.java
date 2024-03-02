//벽뿌2 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr;
	static boolean[][][] visited;

	static class Node{
		int x;
		int y;
		int cnt;
		int len;
		
		public Node(int cnt, int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.len = len;
		}
		
	}
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node (0,0,0,1));
		visited[0][0][0] =true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(now.x==N-1 && now.y==M-1) {
				System.out.println(now.len);
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				
				if(nx<0||nx>=N|| ny<0 || ny>=M) {
					continue;
				}
				
				if(arr[nx][ny]==0 && !visited[now.cnt][nx][ny]) {
					visited[now.cnt][nx][ny] = true;
					q.add(new Node (now.cnt,nx,ny,now.len+1));
				}
				else {
					if(now.cnt<K&&!visited[now.cnt+1][nx][ny]) {
						visited[now.cnt+1][nx][ny] = true;
						q.add(new Node (now.cnt+1,nx,ny, now.len+1));
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
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[K+1][N][M];
		
		for(int i =0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<M;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs();
	}

}
