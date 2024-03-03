import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		ArrayList<Integer> res = new ArrayList<>();
		int[] degree = new int[N+1];
		
		for(int i =0;i<N+1;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<n;j++) {
				int c = Integer.parseInt(st.nextToken());
				
				arr[p].add(c);
				degree[c]++;
				p= c;
			}
			
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		if(q.isEmpty()) {
			System.out.println(0);
		}
		else {
			while(!q.isEmpty()) {
				int num = q.poll();
				
				res.add(num);
				for(int i=0;i<arr[num].size();i++) {
					degree[arr[num].get(i)]--;
					if(degree[arr[num].get(i)]==0) {
						q.add(arr[num].get(i));
					}
				}
			}
			
			if(res.size()!=N) {
				System.out.println(0);
			}
			else {
				for(int n : res) {
					System.out.println(n);
				}
			}
		}
		
	}

}
