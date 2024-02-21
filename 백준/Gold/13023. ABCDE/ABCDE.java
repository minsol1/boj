import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int to;
		Node next;
		
		Node(int to, Node n){
			this.to = to;
			this.next = n;
		}
	}
	
	static boolean dfs(int cnt, int cur) {
		if(cnt == 5) {
			return true;
		}
		boolean flag = false;
		if(cur == -1) {
			for(int next=0; next<N; next++) {
				if(MAP[next]!=null)
					flag = flag || dfs(1, next);
			}
		}
		else {
			visited[cur] = true;
			Node n = MAP[cur];
			while(n!=null) {
				if(!visited[n.to] && !flag) {
					flag = flag || dfs(cnt+1, n.to);
				}
				n = n.next;
			
			}
			visited[cur] = false;
		}
		
		return flag;
	}
	
	static boolean[] visited;
	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Node [] MAP;
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited= new boolean[N];
		MAP = new Node[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1= Integer.parseInt(st.nextToken());
			int num2= Integer.parseInt(st.nextToken());
			MAP[num1] = new Node(num2, MAP[num1]);
			MAP[num2] = new Node(num1, MAP[num2]);
		}
		if(dfs(0, -1))System.out.println(1);
		else System.out.println(0);
	}

}
