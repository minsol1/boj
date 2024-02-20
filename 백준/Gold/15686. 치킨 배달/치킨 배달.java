import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static int[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Deque<int[]> q; 
	static ArrayList<int[]> pos;
	static ArrayList<int[]> clist;
	static int res;
	
	static int bfs() {
		int c = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int d=0;d<4;d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					continue;
				}
				if(visited[nx][ny]==-1) {
					visited[nx][ny] = visited[now[0]][now[1]]+1;
					q.add(new int[] {nx,ny});
					
					if(arr[nx][ny]==1) {
						c+= visited[nx][ny];
					}
				}
			}
		}
		
		return c;
	}
	
	static void bt(int idx, int cnt) {
		if(cnt == M) { // 치킨집 m개 조합 찾으면 bfs 
			
			for(int i=0;i<N;i++) {
				Arrays.fill(visited[i], -1);
			}
			
			for(int i = 0;i<M ;i++) {
				q.add(clist.get(i));
				visited[clist.get(i)[0]][clist.get(i)[1]]++;
			}
			
			res = Math.min(res, bfs() ); // 거리합이 최소보다 작으면 리셋
			return;
		}
		
		for(int i= idx ; i<pos.size();i++) {
			clist.add(cnt, pos.get(i));
			bt(i+1, cnt+1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N]; // 맵 
		visited = new int[N][N]; // bfs 할때 
		pos = new ArrayList<>(); // 치킨집 위치 
		clist = new ArrayList<>(); // 선택된 치킨집  
		q = new ArrayDeque<int[]>(); // 방문큐
		res = 10000000; // 결과 
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if( arr[i][j]==2) { // 치킨집 찾으면 위치 넣어줌 
					pos.add(new int[] {i,j});
				}
			}
		}
		
		bt(0,0);
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println(" ");
//		}
		System.out.println(res);

	}

}
