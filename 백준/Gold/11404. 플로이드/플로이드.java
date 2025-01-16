import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 플로이드 


public class Main {
	static int N,M;
	static int[][] arr;
	static int[][] dist;
	static int inf;
	
	static void dij(int s) {
		// dist init
		for(int i=1;i<N+1;i++) {
			dist[s][i]=inf;
		}
		dist[s][s] = 0;
		// dist기준으로 오름차순 
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
			
		});
		
		pq.add(new int[] {0,s});
		
		while(!pq.isEmpty()) {
			int curDist = pq.peek()[0];
			int curNode = pq.peek()[1];
			pq.poll();
			
			for(int i=1;i<N+1;i++) {
				int nDist = curDist + arr[curNode][i];
				
				if(nDist < dist[s][i]) {
					dist[s][i] = nDist;
					pq.add(new int[] {nDist,i});
				}
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dist = new int[N+1][N+1];
		inf = 100000*(N+1);
		for(int i =1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				arr[i][j]= i==j?0:inf;
			}
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[s][e] = arr[s][e]<c? arr[s][e]: c;
		}
		
		for(int i =1;i<N+1;i++) {
			dij(i);
		}
		
		for(int i = 1;i<N+1;i++) {
			for(int j =1; j<N+1;j++) {
				if(dist[i][j]==inf) {
					dist[i][j]=0;
				}
				System.out.print(dist[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
