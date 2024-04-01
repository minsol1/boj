import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

//다리만들기2
public class Main {
	static int N,M;
	static int[][] arr;
	static int[] parent;
	static ArrayList<int[]> dist;
	static int res;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	static void numbfs(int x, int y, int num) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {x,y});
		arr[x][y] = num;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				
				if(nx<0||nx>=N || ny<0|| ny>=M || arr[nx][ny]!=1) {
					continue;
				}
				arr[nx][ny] = num;
				q.add(new int[] {nx,ny});
			}
		}
		
		
	}
	static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		else {
			return find(parent[x]);
		}
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parent[y] = x;
		}else {
			parent[x] = y;
		}
		
	}
	
	static void kru() {
		int cnt=0;
		for(int i=0;i<dist.size();i++) {
			if(find(dist.get(i)[0])!=find(dist.get(i)[1]) ) {
				union(dist.get(i)[0],dist.get(i)[1]);
				res+= dist.get(i)[2];
				cnt++;
				
				if(cnt == parent.length-3) {
					return;
				}
			}
		}
		res=-1;
	}
	
	static void bfs(int x,int y,int s, int dir) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x,y,0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int nx = now.x+dx[dir];
			int ny = now.y+dy[dir];
			
			if(nx<0|| ny<0|| nx>=N || ny>=M || arr[nx][ny]==s) {
				continue;
			}
			if(arr[nx][ny]==0) {
				q.add(new Node(nx,ny,now.cnt+1));
				
			}
			else {
				if(now.cnt<2) {
					continue;
				}
				else {
					if(s<arr[nx][ny]) {
						dist.add(new int[] {s,arr[nx][ny],now.cnt});
					}
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
		dist = new ArrayList<>();
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num=1;
		for(int i =0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(arr[i][j]==1) {
					num++;
					numbfs(i,j,num);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					bfs(i,j,arr[i][j],0);
					bfs(i,j,arr[i][j],1);
					bfs(i,j,arr[i][j],2);
					bfs(i,j,arr[i][j],3);
				}
			}
		}
		Collections.sort(dist,(o1,o2)-> o1[2]-o2[2]);
	
		parent = new int[num+1];
		
		for(int i =0;i<num+1;i++) {
			parent[i] = i;
		}
		
		kru();
		System.out.println(res);

	}

}
