import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static boolean[] visited;
	static int res;
	static int N;
	static int[][] arr;
	
	static void bt(int idx , int cnt , int sum) { // 이전 노드 , 방문 횟수, 총 거리
		if(cnt==N) {
			sum += Math.abs(arr[idx][0] -arr[1][0] )+Math.abs(arr[idx][1] -arr[1][1] ); // 마지막에서 집까지의 거리 
			res = Math.min(res, sum);
		}
		
		for(int i=2; i<N+2 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bt(i,cnt+1,sum+Math.abs(arr[idx][0] -arr[i][0] )+Math.abs(arr[idx][1] -arr[i][1] ));
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[N+2][2]; // 위치 정보
			visited = new boolean[N+2]; // 방문여부
			res = Integer.MAX_VALUE; // 결과
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N+2;i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[i][0] = x;
				arr[i][1] = y;
				
			}
			
			bt(0,0,0);
			
			System.out.printf("#%d %d\n",test_case , res);
			
		}

	}

}
