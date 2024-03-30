import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static boolean[][][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	static int res= Integer.MAX_VALUE;
	static Queue<Node> q = new ArrayDeque<>();
	
	static class Node{
		int x;
		int y;
		int cnt;
		int key;
		public Node(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int d=0;d<4;d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(nx<0|| nx>=N || ny<0 || ny>=M || arr[nx][ny]=='#'||visited[nx][ny][now.key]) {
					continue;
				}
				if(arr[nx][ny]=='1') {
					res = res<now.cnt+1? res : now.cnt+1;
					return;
				}
				if(arr[nx][ny]=='.'||arr[nx][ny]=='0') {
					visited[nx][ny][now.key]= true;
					q.add(new Node(nx,ny,now.cnt+1,now.key));
					
				}else if(arr[nx][ny]>='A'&&arr[nx][ny]<='F' ){// 문 
					if(((1<<(arr[nx][ny]-'A'))&now.key)>=1) {//키잇음 
						visited[nx][ny][now.key]= true;
						q.add(new Node(nx,ny,now.cnt+1,now.key));
						
					}
				}else { // 키 
					visited[nx][ny][now.key] = true;
					visited[nx][ny][now.key|(1<<(arr[nx][ny]-'a'))]=true;
					q.add(new Node(nx,ny,now.cnt+1, now.key|(1<<(arr[nx][ny]-'a')))); 
					
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
		visited = new boolean[N][M][1<<6];
		arr = new char[N][M];
		
		for(int i = 0; i<N;i++) {
			String str = br.readLine();
			for(int j =0;j<M;j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j]=='0') {
					q.add(new Node(i,j,0, 0));
					visited[i][j][0] = true;
				}
			}
		}
		
		bfs();
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			
			System.out.println(res);
		}
		
	}

}
