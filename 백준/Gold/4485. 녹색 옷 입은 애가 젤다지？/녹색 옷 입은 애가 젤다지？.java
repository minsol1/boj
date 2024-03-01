import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 젤다 
public class Main {
	static int N;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int[][] dist;

	static void di() {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[2]-o2[2]);
		q.add(new int[] { 0, 0 ,arr[0][0]});
		dist[0][0] = arr[0][0];

		while (!q.isEmpty()) {
			int[] now = q.poll();
	
			if(now[0] == N-1 && now[1] == N-1) {
				return;
			}

			for (int d = 0; d < 4; d++) {

				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N ) {
					continue;
				}
				if (dist[nx][ny] > dist[now[0]][now[1]] + arr[nx][ny]) {
					dist[nx][ny] = dist[now[0]][now[1]] + arr[nx][ny];
					q.add(new int[] { nx, ny ,dist[nx][ny]});
				}
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int t = 1;
		while (N != 0) {
			arr = new int[N][N];
			dist = new int[N][N];
			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = 10*N*N;
				}
			}

			di();

			System.out.printf("Problem %d: %d\n", t, dist[N - 1][N - 1]);
			
			t++;
			N = Integer.parseInt(br.readLine());
		}
	}
}