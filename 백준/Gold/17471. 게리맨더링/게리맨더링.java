import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] MAP;
	static boolean[] visited;
	static BufferedReader br;
	static int people[];
	static int ret = Integer.MAX_VALUE;
	static List<Integer> trueList;
	static List<Integer> falseList;
	static boolean BFS() {
		boolean visiting[] = new boolean[N];
		visiting[trueList.get(0)] = true;
		List<Integer> qTrue = new ArrayList<>();
		qTrue.add(trueList.get(0));
		int idx =0;
		while(idx<qTrue.size()) {
			int cur = qTrue.get(idx++);
			for(int next=0; next<N; next++) {
				if(MAP[cur][next] == 0 )continue;
				if(visited[next] != visited[cur]) continue;
				if(visiting[next]) continue;
				qTrue.add(next);
				visiting[next] = true;
			}
		}
	//	System.out.println(qTrue.size());
		if(qTrue.size() != trueList.size()) return false;
		
		List<Integer> qFalse = new ArrayList<>();
		visiting = new boolean[N];
		visiting[falseList.get(0)] = true;
		qFalse.add(falseList.get(0));
		idx = 0;
		while(idx<qFalse.size()) {
			int cur = qFalse.get(idx++);
			for(int next=0; next<N; next++) {
				if(MAP[cur][next] == 0 )continue;
				if(visited[next] != visited[cur]) continue;
				if(visiting[next]) continue;
				qFalse.add(next);
				visiting[next] = true;
			}
		}
		if(falseList.size() != qFalse.size()) return false;
		return true;
	}
	
	
	static boolean isConnect() {
		trueList = new ArrayList<>();
		falseList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			if(visited[i]) trueList.add(i);
			else falseList.add(i);
		}
		//System.out.println(trueList.size() + " " + falseList.size());
		
		return BFS();
	}
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		MAP = new int[N][N];
		visited=new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			MAP[i][i] = 1;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int num2 = Integer.parseInt(st.nextToken())-1;
				MAP[i][num2] = 1;
				MAP[num2][i] = 1;
			}
		}
		//집단 나누기
		for(int i=1; i<(1<<N-1); i++) {
			for(int j=0; j<N; j++) {
				if((i & 1<<j) !=0) {
					visited[j] = true;
				}
				else {
					visited[j] = false;
				}
			}
			
			if(isConnect()) {
				int sumTrue =0;
				int sumFalse = 0;
				for(int j=0; j<N; j++) {
					if(visited[j]) sumTrue+=people[j];
					else sumFalse+=people[j];
				}
				//System.out.println(sumTrue + " " + sumFalse);
				ret = Math.min(ret, Math.abs(sumTrue - sumFalse));
			}
		}
		
		System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
		
	}

}
