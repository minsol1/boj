
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int v;
	int w;
	
	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.w -o.w;
	}
}

public class Main {
	static int[] dist;
	static ArrayList[] li;
	static ArrayList[] v;
	static boolean[] visited;
	static int N;
	static int M;
	static int S;
	static int E;
	
	static int di(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s,0));
		dist[s] = 0;
		v[s].add(s);
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.v]) {
				visited[now.v] = true;
				
				int len = li[now.v].size();
				for(int i=0;i<len;i++) {
					Node next = (Node) li[now.v].get(i);
					if(!visited[next.v] && dist[next.v] > dist[now.v]+ next.w) {
						dist[next.v] = dist[now.v]+ next.w;
						
						v[next.v] = new ArrayList<>(v[now.v]);
						v[next.v].add(next.v);
						
						pq.add(new Node(next.v, dist[next.v]));
					}
				}
			}
		}
		
		return dist[E];
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		li = new ArrayList[N+1];
		v = new ArrayList[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			li[i] = new ArrayList<Node>();
			v[i] = new ArrayList<Integer>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			li[v].add(new Node(e,w));
			
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		System.out.println(di(S));
		
		int size = v[E].size();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.print(v[E].get(i)+" ");
		}
		
	}
}
