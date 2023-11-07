import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class Pos implements Comparable<Pos>{
	int x;
	int y;
	int time;
	
	Pos(int x, int y, int time){
		this.x = x;
		this.y= y;
		this.time = time;
	}

	@Override
	public int compareTo(Pos o) {
		if(this.time > o.time) return 1;
		else if(this.time < o.time) return -1;
		return 0;
	}
	
}

public class Solution {
	public static int[][] graph;
	public static boolean[][] visited;
	public static int[][] ans;
	public static int[] dx = new int[] {1,-1,0,0};
	public static int[] dy = new int[] {0,0,1,-1};
	public static int N ;
	public static int min;
	

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			ans = new int[N][N];
			visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					graph[i][j] = str.charAt(j)-'0';
				}
			}
			
			bfs(0,0);
			
			System.out.println("#"+test_case+" "+min);
			
		}
	}
	public static void bfs(int i, int j) {
		PriorityQueue<Pos> q= new PriorityQueue<>();
		q.offer(new Pos(i,j,0));
		visited[i][j]= true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			if(now.x==N-1 && now.y==N-1) {
				min = Math.min(min, now.time);
			}
			if(min <= now.time) continue;
			
			for(int d = 0; d<4 ;d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					int v = now.time + graph[nx][ny];
					if(!visited[nx][ny] || ans[nx][ny]>v){
						visited[nx][ny] =true;
						ans[nx][ny] = v;
						q.offer(new Pos(nx,ny,v));
					}
				}
			}
		}
	}
}

