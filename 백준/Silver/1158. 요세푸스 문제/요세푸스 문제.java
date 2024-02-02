import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		ArrayList<Integer> res = new ArrayList<>();
		
		Queue<Integer> q =new LinkedList<Integer>();
		for(int i=1;i<N+1;i++) {
			q.add(i);
		}
		int c =1;
		while(!q.isEmpty()) {
			int n = q.poll();
			if(c%K==0) {
				res.add(n);
			}else {
				q.add(n);
			}
			c++;
		}
		sb.append('<');
		for(int i=0;i<res.size();i++) {
			if(i==0) {
				sb.append(res.get(i));
				
			}else {
				sb.append(", ").append(res.get(i));
				
			}
		}
		sb.append('>');
		
		System.out.println(sb);
	}
	

}
