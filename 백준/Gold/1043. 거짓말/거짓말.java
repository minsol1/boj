import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N,M,K;
	public static ArrayList<Integer>[] party;
	public static int[] parent;
	public static int[] arr; // 진실을 아는 사람 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		parent = new int[N+1];
		
		for(int i =0;i<K;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[M];
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			party[i] = new ArrayList<>();
			for(int j = 0 ; j<n;j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i<N+1;i++) {
			parent[i] = i;
		}
		
		
		for(int i =0;i<M;i++) {
			int n = party[i].get(0);
			
			for(int j =1;j<party[i].size();j++) {
				union(n, party[i].get(j));
			}
		}
		
		int res= M;
		
		for(int i =0;i<M; i++) {
			int n = party[i].get(0);
			
			for(int j =0;j<K;j++) {
				if(find(arr[j]) ==find(n)) {
					res--;
					break;
				}
			}
		}

		System.out.println(res);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
        if (x != y) {
            parent[y] = x;
        }
    
	}
	
	public static int find (int x) {
		if(x == parent[x]) {
			return x;
		}
		return find(parent[x]);

	}

}
