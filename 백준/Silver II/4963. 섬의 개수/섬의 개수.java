import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int [][]board;
	static boolean [][] visited;
	static int [][]GO = {{-1, 0}, {0, -1},{1,0},{0,1}, {-1,-1},{1,-1},{1,1},{-1,1}};
	static class IslandPos{
		int row;
		int col;
		
		IslandPos(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		while(H != 0 || W !=0) {
			int ret=0;
			visited = new boolean[H][W];
			board = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visited[i][j] && board[i][j] > 0) {
						ret+=bfs(i,j);
					}
				}
			}
			
			System.out.println(ret);
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
	}
	
	static boolean isAvailable(int row, int col) {
		return row >=0 && row <H && col >=0 && col<W;
	}
	
	static int bfs(int curRow, int curCol) {
		Queue<IslandPos> q = new ArrayDeque<>();
		visited[curRow][curCol] = true;
		q.add(new IslandPos(curRow, curCol));
		while(!q.isEmpty()) {
			int crow = q.peek().row;
			int ccol = q.peek().col;
			q.poll();
			for(int i=0; i<8; i++) {
				int nextRow = crow+GO[i][0];
				int nextCol = ccol+GO[i][1];
				if(!isAvailable(nextRow, nextCol)) continue;
				if(board[nextRow][nextCol] ==0) continue;
				if(visited[nextRow][nextCol]) continue;
				visited[nextRow][nextCol] = true;
				q.add(new IslandPos(nextRow, nextCol));
			}

		}
		return 1;
	}

}
