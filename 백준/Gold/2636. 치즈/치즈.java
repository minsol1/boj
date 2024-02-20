import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Cheese{
		int row;
		int col;
		int value;
		public Cheese(int row, int col, int value) {
			super();
			this.row = row;
			this.col = col;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Cheese [row=" + row + ", col=" + col + ", value=" + value + "]";
		}

	}
	
	static int retT=0;	//걸린시간
	static int retCheese =0; //마지막 치즈
	static Cheese[][] MAP;
	static List<Cheese> eList = new ArrayList<>();
	static List<Cheese> cList = new ArrayList<>();
	static boolean [][] visited;
	static int R;
	static int C;
	static BufferedReader br;
	static int GO[][] = {{-1, 0},{0, -1}, {1,0}, {0,1}};
	
	static void solution() {
		while(!eList.isEmpty()) {
			for(Cheese chz : eList) {
				Queue<Cheese> q = new ArrayDeque<>();
				q.add(chz);
				while(!q.isEmpty()) {
					int curRow = q.peek().row;
					int curCol = q.peek().col;
					q.poll();
					for(int i=0; i<4; i++) {
						int nextRow = curRow + GO[i][0];
						int nextCol = curCol + GO[i][1];
						if(nextRow <0 || nextRow >=R || nextCol <0 || nextCol >= C) continue;
						if(visited[nextRow][nextCol]) continue;
						if(MAP[nextRow][nextCol].value ==1 ) { //경계부분
							MAP[nextRow][nextCol].value=0;	//이게 끝나면 1시간 후가 되기 때문에 노상관임 
							cList.add(MAP[nextRow][nextCol]);
						}
						else {
							q.add(MAP[nextRow][nextCol]);
						}
						visited[nextRow][nextCol] = true;
					}
				}
			}
			retT++;
		//	for(Cheese c : cList)
		//		System.out.println(c);
		//	System.out.println("time: " + " " + retT + "=====================================================" );
		//	System.out.println();
			if(cList.size() !=0) retCheese = cList.size();
			eList = cList;
			cList = new ArrayList<Cheese>();
		}
	}
	
	public static void main(String[] args) throws IOException{
		br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MAP = new Cheese[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int value = Integer.parseInt(st.nextToken());
				MAP[i][j] = new Cheese(i,j,value);
			}
		}
		visited[0][0] = true;
		eList.add(new Cheese(0,0,0));
		solution();
		System.out.println((retT-1) + " " + retCheese);
	}
}
