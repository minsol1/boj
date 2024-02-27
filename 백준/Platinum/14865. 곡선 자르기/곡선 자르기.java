import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Pair implements Comparable<Pair>{
		Pos left;
		Pos right;
		public Pair(Pos left, Pos right) {
			super();
			this.left = left;
			this.right = right;
		}
		void swap() {
			if(left.x > right.x) {
				Pos temp = right;
				right = left;
				left = temp;
			}
		}
		@Override
		public String toString() {
			return "Pair [left=" + left + ", right=" + right + "]";
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(left.x, o.left.x);
		}
		
	}
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static List<Pos> pList;
	static List<Pair> board;
	static int N;
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//왼쪽 아래 인덱스 찾기
		int minX=Integer.MAX_VALUE;
		int minIdx=0;
		N = Integer.parseInt(br.readLine());
		pList = new ArrayList<>();
		board = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pList.add(new Pos(x, y));
		}
		//System.out.println(minRow + " " +minCol);
		//왼쪽아래로 만듬
		for(int i=0; i<N; i++) {
			if(minX > pList.get(i).x && pList.get(i).y < 0) {
				minX = pList.get(i).x;
				minIdx = i;
			}
		}
		List<Pos> temp1 = new ArrayList<>();
		int ct=0;
		int nextIdx = minIdx;
		while(ct < N) {
			temp1.add(pList.get(nextIdx++));
			nextIdx = (nextIdx)%N;
			ct++;
		}
		pList = temp1;

	//	System.out.println(Arrays.deepToString(pList.toArray()));
		
		//Pair 찾기
		boolean left =true;
		Pos l=null, r=null;
		for(int i=1; i<=N; i++) {
			if(((pList.get(i-1).y < 0) && (pList.get(i%N).y > 0)) || ((pList.get(i-1).y >0) && (pList.get(i%N).y < 0))) {
				if(left) {
					l = new Pos(pList.get(i%N).x, 0);
					left = !left;
				}
				else if(!left) {
					r = new Pos(pList.get(i%N).x, 0);
					Pair p = new Pair(l, r);
					p.swap();
					board.add(p);
					left = !left;
				}
				
			}
		}
		
		Collections.sort(board);
		
//		for(Pair p : board)
//			System.out.println(p);
//		System.out.println(Arrays.deepToString(board.toArray()));
		
		
		//stack이 null일 때 (이면 바깥거 오픈
		//stack이 null이 아닐 때 () 총모양이면 inner +1
		int upper=0;
		int inner =0;
		StringBuilder sb = new StringBuilder();
		Stack<Pair> s = new Stack<>();
		for(Pair p : board) {
			//System.out.println(p);
			if(s.isEmpty()) {
				s.add(p);
				sb.append("(");
			}
			else {
				while(!s.isEmpty()&& (s.peek().right.x < p.left.x || s.peek().left.x > p.right.x)) {
					sb.append(")");
					s.pop();
				}
				s.add(p);
				sb.append("(");
				
			}
		}
		while(!s.isEmpty()) {
			sb.append(")");
			s.pop();
		}
		String str = sb.toString();
		//System.out.println(str);
		Stack<Character> stac= new Stack<>();
		stac.add(str.charAt(0));
		int cnt=1;//(개수
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				cnt++;
			}
			else if(str.charAt(i) == ')') {
				cnt--;
				if(stac.peek() =='(') {
					inner++;
				}
				if(cnt==0)
					upper++;
			}
			stac.add(str.charAt(i));
		}

		System.out.println(upper + " " + inner);
	}

}
