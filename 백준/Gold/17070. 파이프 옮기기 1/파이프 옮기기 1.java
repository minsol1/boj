import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] visited;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		visited[0][1] =1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int p = now[0];
			int x = now[1];
			int y = now[2];
			
			if(y+1<N && x+1<N && arr[x+1][y+1]==0 && arr[x][y+1]==0&& arr[x+1][y]==0) { // 대각선으로  이동하기 
				q.add(new int[] {1,x+1,y+1});
				visited[x+1][y+1] ++;
			}
			if(p!=2 && y+1<N&& arr[x][y+1]==0) { // 가로로 이동하기 
				q.add(new int[] {0,x,y+1});
				visited[x][y+1] ++;
			}
			if(p!=0&& x+1<N&& arr[x+1][y]==0) { // 세로로 이동하기 
				q.add(new int[] {2,x+1,y});
				visited[x+1][y] ++;
			}
			
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(arr[N-1][N-1]==1) {
			System.out.println(0);
		}
		else {
			bfs();
			System.out.println(visited[N-1][N-1]);
		}
		
	}

}
