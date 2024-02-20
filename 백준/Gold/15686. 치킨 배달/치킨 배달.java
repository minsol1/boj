import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int [][]board;
	static int ret= Integer.MAX_VALUE;
	static int N, M;
	static List<Pos> chicken = new ArrayList<>();
	static List<Pos> home = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		solution();
		System.out.println(ret);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		chicken = new ArrayList<Pos>();
		home = new ArrayList<Pos>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) home.add(new Pos(i, j));
				if(board[i][j] == 2) chicken.add(new Pos(i, j));
			}
		}
		//System.out.println(chicken.size());
	}
	
	
	static void solution() {
		for(int i=0; i<N; i++) {
			List<Pos> temp = new ArrayList<>();
			dfs(-1, temp);
		}
	}
	
	static void dfs(int start, List<Pos> curChicken) {
		if(curChicken.size() == M) {
			//집과의 거리 구하기
			int sum=0;	//집들과의 거리 합
			for(int i=0; i<home.size(); i++) {
				int curRow = home.get(i).row;		//치킨집 현재 위치
				int curCol = home.get(i).col;
				int diffRow=0;							//행 차이
				int diffCol=0;							//열차이
				int minSum = Integer.MAX_VALUE;
				for(int j=0; j<curChicken.size(); j++) {
					diffRow = Math.abs(curRow - curChicken.get(j).row);	//행차이와 
					diffCol = Math.abs(curCol - curChicken.get(j).col);	//열차이가 가장 적은 놈 찾는다.
					minSum = Math.min(diffRow + diffCol, minSum);
				}
				sum+=minSum;
			}
			ret = Math.min(ret, sum);
			return;
		}
		
		
		for(int i = start+1; i<chicken.size(); i++) {
			List<Pos> temp = new ArrayList<>(curChicken);
			temp.add(chicken.get(i));
			dfs(i, temp);
		}
	}
	
	
	
	//조합문제
	//조합으로 치킨집고르기 -> M개 고름 -> min 구함

}

class Pos{
	int row;
	int col;
	Pos(int row, int col){
		this.row = row;
		this.col = col;
	}
}
