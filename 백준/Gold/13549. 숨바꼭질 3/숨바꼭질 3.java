import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] graph;
	public static int[] visited;
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n]++;
		
		while(!q.isEmpty()) {
			int x= q.poll();
			
			int[] nx =new int[] {x*2,x-1, x+1};
			
			for(int i=0; i<3;i++) {
				if(nx[i]>=0&& nx[i]<100001) {/////////간선의 길이가 다름(순간이동은 0 걷기는1) 그래서 먼저 도착햇다고 최단거리가 아님 
					/////////////그래서 방문조건을방문여부가 아니라 기존보다 짧냐?? 로 해야함 
					int v;
					if(i==0) v = visited[x];
					else v = visited[x]+1;
					
					if(visited[nx[i]]==-1 || visited[nx[i]]>v) {
						visited[nx[i]]=v;
						q.add(nx[i]);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		graph = new int[100001];
		visited = new int[100001];

		Arrays.fill(visited, -1);
		
		bfs(N);
		
		System.out.println(visited[K]);
	}

}
