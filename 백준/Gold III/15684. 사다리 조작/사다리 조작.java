import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int H;
	static int[][] arr;
	static int res;
	static boolean f;
	
	static void dfs(int h, int cnt, int n) {
		if (f) return;
        if (n == cnt) {
            if (check()) f = true;
            return;
        }

        for (int i = h; i <H+1; i++) {
            for (int j = 1; j <N; j++) {
                if (arr[i][j] == 0 && arr[i][j+1] == 0) {
                	arr[i][j] = 1;
                	arr[i][j+1] = 2;
                    dfs(i, cnt + 1,n);
                    arr[i][j] = arr[i][j+1] = 0;
                }
            }
        }
	}

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < H; j++) {
                if (arr[x][y] == 1) y++;
                else if (arr[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H+1][N+1];
		res = -1;
		f = false;
		
		for(int i=0;i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			arr[h][n] = 1; // 오 
			arr[h][n+1] = 2; // 왼 
			
		}
		
		for(int i=0;i<=3;i++) {
			dfs(1,0,i);
			
			if(f) {
				res  = i;
				break;
			}
		}
		
		System.out.println(res);
		

	}

}
