import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int now=0;
		Stack<Integer> bs = new Stack<>();
		Stack<Integer> fs = new Stack<>();

		for( int t=0;t<M;t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("A")) {
				int n = Integer.parseInt(st.nextToken());
				
				if(now!=0) {
					bs.push(now);
				}
				now =n;
				fs.clear();
				
				
			}else if(str.equals("B")) {
				if(!bs.isEmpty()) {
					fs.push(now);
					now = bs.pop();
				}
				
			}else if(str.equals("F")) {
				if(!fs.isEmpty()) {
					bs.push(now);
					now = fs.pop();
				}
			}else if(str.equals("C")) {
				Stack<Integer> arr = new Stack<>();
				if(!bs.isEmpty()) {
					while(!bs.isEmpty()) {
						int n = bs.pop();
						
						if(arr.isEmpty() || arr.peek()!=n) {
							arr.push(n);
						}
					}
					bs.clear();
					while(!arr.isEmpty()) {
						bs.add(arr.pop());
					}
				}
			}
			
		}
		
		System.out.println(now);
		if(!bs.isEmpty()) {
			while(!bs.isEmpty()) {
				System.out.print(bs.pop()+" ");
			}
			System.out.println("");
		}else {
			System.out.println(-1);
		}
		if(!fs.isEmpty()) {
			while(!fs.isEmpty()) {
				System.out.print(fs.pop()+" ");
			}
			System.out.println("");
		}else {
			System.out.println(-1);
		}
		
	}

}
