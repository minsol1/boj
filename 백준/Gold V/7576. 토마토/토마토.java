import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	static class Tomato{
		int row;
		int col;
		int days;
		public Tomato(int row, int col, int days) {
			this.row = row;
			this.col = col;
			this.days = days;
		}
	}
	
	static int M, N; //M: col, N: row
	static int [][]MAP;
	static boolean [][] visited;
	static int [][] GO = {{-1, 0},{0, -1},{1,0},{0,1}};
	
	
	static boolean canGo(int nextRow, int nextCol) {
		if(nextRow <0 || nextRow >=N ||nextCol <0 || nextCol >=M) return false;
		else return true;
	}
	
	public static void main(String[] args) throws IOException{
		Queue<Tomato> q = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		MAP = new int[N][M];
		visited = new boolean[N][M];
		int ret=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
				if(MAP[i][j] == 1) {
					q.add(new Tomato(i,j,1));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int curRow = q.peek().row;
			int curCol = q.peek().col;
			int curdays = q.peek().days;
			q.poll();
			for(int i=0; i<4; i++) {
				int nextRow = curRow +GO[i][0];
				int nextCol = curCol + GO[i][1];
				int nextdays = curdays +1;
				if(!canGo(nextRow, nextCol)) continue;
				if(visited[nextRow][nextCol]) continue;
				if(MAP[nextRow][nextCol] == -1) continue;
				visited[nextRow][nextCol] = true;
				MAP[nextRow][nextCol] = nextdays;
				q.add(new Tomato(nextRow, nextCol, nextdays));
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(MAP[i][j] ==0) {
					System.out.println(-1);
					return;
				}
				ret = Math.max(ret, MAP[i][j]);
			}
		}
		System.out.println(ret-1);
		
		
	}

}
