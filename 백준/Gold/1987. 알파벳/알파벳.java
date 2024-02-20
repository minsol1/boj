import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos{
		int row;
		int col;
		int T=0;
		public Pos(int row, int col,int T) {
			super();
			this.row = row;
			this.col = col;
			this.T = T;
		}
		
	}
	
	static boolean visited[] = new boolean[30];	//Alphabet 인덱싱
	static boolean visitedMAP[][];
	static int R, C;
	static char [][] MAP;
	static BufferedReader br;
	static int GO[][]  = {{0,1},{1,0},{-1,0},{0,-1}};
	static int ret=0;
	
	static int DFS(int curRow, int curCol)
	{
		int sum=1;
		visitedMAP[curRow][curCol] = true;
		visited[MAP[curRow][curCol] - 'A']= true;
		
		for(int i=0; i<4; i++) {
			int nextRow = curRow + GO[i][0];
			int nextCol = curCol + GO[i][1];
			if(nextRow <0 | nextRow >(R-1) || nextCol <0 || nextCol >(C-1)) continue;
			if(visitedMAP[nextRow][nextCol]) continue;
			if(visited[MAP[nextRow][nextCol] - 'A']) continue;
		//	System.out.println(MAP[nextRow][nextCol]);
			
			sum= Math.max(sum, 1 + DFS(nextRow, nextCol));
		}
		
		visitedMAP[curRow][curCol] = false;
		visited[MAP[curRow][curCol] - 'A']= false;
		
		return sum;
	}
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MAP = new char[R][C];
		visitedMAP = new boolean[R][C];
		for(int i=0; i<R; i++) {
			MAP[i] = br.readLine().toCharArray();
		}
		
		visited[MAP[0][0]-'A'] = true;
		visitedMAP[0][0] = true;
		ret = DFS(0,0);
		
		System.out.println(ret);
	}

}
