
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int res;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int N=100;
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int [] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int d =0; d<4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					continue;
				}
				if(!visited[nx][ny] && arr[nx][ny]==0) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
				else if(arr[nx][ny]==3) {
					res =1;
					return;
				}
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			res =0;
			
			for(int i =0;i<N ; i++) {
				String str = br.readLine();
				for(int j=0;j<N ; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			for(int i=0;i<N ; i++) {
				for(int j=0;j<N ; j++) {
					if(arr[i][j] == 2) {
						bfs(i,j);
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n",test_case, res);
			
		}
	}

}
