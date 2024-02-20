import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Pos{
		int row; int col;

		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	static int retColorBlindness=0;
	static int retNormal=0;
	static char MAPBlindness[][];
	static char MAP[][];
	static int GO[][] = {{-1, 0},{0, -1}, {1, 0}, {0,1}};
	static boolean [][] visited;
	static BufferedReader br;
	static int N;
	static int BFS(int curRow, int curCol, char curChar, boolean flag) {	//flag true일 땐 정상, flag false 일 땐 색맹
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(curRow, curCol));
		while(!q.isEmpty()) {
			int cr = q.peek().row;
			int cc = q.peek().col;
			q.poll();
			for(int i=0; i<4; i++) {
				int nextRow = cr +GO[i][0];
				int nextCol = cc + GO[i][1];
				if(nextRow <0 || nextCol <0 || nextRow >=N || nextCol >=N) continue;
				if(visited[nextRow][nextCol]) continue;
				if(flag && MAP[nextRow][nextCol] != curChar) continue;
				if(!flag && MAPBlindness[nextRow][nextCol] != curChar) continue;
				visited[nextRow][nextCol] = true;
				q.add(new Pos(nextRow, nextCol));
			}
		}
		
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException{
		br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MAP = new char[N][N];
		MAPBlindness = new char[N][N];
		for(int i=0; i<N; i++) {
			char[] str = br.readLine().toCharArray();
			MAP[i] = str;
			for(int j =0; j< str.length; j++) {
				if(MAP[i][j] == 'G')
					MAPBlindness[i][j] = 'R';
				else MAPBlindness[i][j] = MAP[i][j];
			}
		}
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					retNormal+= BFS(i,j,MAP[i][j], true);
				}
			}
		}
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					retColorBlindness+= BFS(i,j,MAPBlindness[i][j], false);
				}
			}
		}
		
		System.out.println(retNormal + " " +retColorBlindness);
		
	}
		
}
