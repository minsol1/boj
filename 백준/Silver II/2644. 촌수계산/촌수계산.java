import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Relation{
		int curNode;
		int relation;
		public Relation(int curNode, int relation) {
			this.curNode = curNode;
			this.relation = relation;
		}
		
	}
	
	static int N;
	static int node1, node2;
	static int m;
	static int [][] MAP;
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		MAP = new int [N+1][N+1];
		visited = new boolean [N+1];
		st = new StringTokenizer(br.readLine());
		node1= Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			MAP[n1][n2]=MAP[n2][n1]=1;
		}
		
		visited[node1] = true;
		Queue<Relation> q = new ArrayDeque<>();
		q.add(new Relation(node1, 0));
		while(!q.isEmpty()) {
			int curNode = q.peek().curNode;
			int curRelation = q.peek().relation;
			q.poll();
			
			for(int next = 1; next<=N; next++) {
				if(visited[next]) continue;
				if(MAP[curNode][next] == 0) continue;
				
				if(next == node2) {
					System.out.println(curRelation+1);
					return;
				}
				q.add(new Relation(next, curRelation+1));
				visited[next]=true;
			}
		}
		
		System.out.println(-1);
	}
	
	

}
