import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int data;
		int idx;
		
		public Node(int data, int idx) {
			this.data = data;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine());
		Stack<Node> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			int res =0;
			
			while(!stack.isEmpty()) {
				if(stack.peek().data>=n) {
					res = stack.peek().idx;
					break;
					
				}else {
					stack.pop();
				}
			}
			sb.append(res).append(" ");
			stack.add(new Node(n,i+1));
		}
		
		System.out.println(sb);

	}

}
