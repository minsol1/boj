import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos{
		int row;
		int col;
		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	
	static int bfs(Pos p) {
		int cnt=1;
		q.add(p);
		visited[p.row][p.col] = true;
		while(!q.isEmpty()) {
			int curRow = q.peek().row;
			int curCol = q.peek().col;
			q.poll();
			for(int i=0; i<4; i++) {
				int nextRow = curRow + GO[i][0];
				int nextCol = curCol + GO[i][1];
				if(nextRow <0 || nextRow >=N || nextCol < 0 || nextCol >=N) continue;
				if(visited[nextRow][nextCol]) continue;
				if(MAP[nextRow][nextCol] == 0) continue;
				q.add(new Pos(nextRow, nextCol));
				visited[nextRow][nextCol]=true;
				cnt++;
			}
		}
		return cnt;
	}
	static int[][] GO = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Pos> q;
	static boolean visited[][];
	static int N;
	static int[][] MAP;
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer> pList = new ArrayList<>();
		visited = new boolean[N][N];
		MAP = new int[N][N];
		for(int i=0; i<N; i++) {
			char [] ch = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				MAP[i][j] = ch[j]-'0';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && MAP[i][j] == 1) {
					q = new ArrayDeque<Pos>();
					pList.add(bfs(new Pos(i,j)));
				}
			}
		}
		System.out.println(pList.size());
		Collections.sort(pList);
		for(int i=0; i<pList.size(); i++)
			System.out.println(pList.get(i));
	}

}
