import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int[] num; //순서
    public static boolean[] visited;
    public static int res;

    public static void dfs(int idx){
        if(idx ==9){
            play();
            return;
        }

        if(idx == 3)
            dfs(idx+1);
		else{
	        for(int i =1;i<9;i++){
    	        if(!visited[i]){
        	        num[idx] = i;
            	    visited[i] = true;
                	dfs(idx+1);
                	visited[i] = false;
            	}
        	}	
		}

    }

    public static void play(){
        int out = 0;
        int score = 0;
		int[] pos = new int[9]; // 위치

		int n =0; // 이닝수
		int seq =0; // 순서
		while(n <N){
			int people = num[seq];
			int c = arr[n][people];

			seq = (seq+1)%9;
			if(c == 0) {
				out++;
				if(out ==3){
					n++;
					out =0;
					Arrays.fill(pos,0);
					continue;
				}
			}

			for(int i =0;i<9;i++){
				if(pos[i]!=0 || i == people){
					pos[i] += c;
					
					if(pos[i] >= 4){
						score++;
						pos[i] = 0;
					}
				}
			}

		}
		res = res > score ? res : score ;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];
        num = new int[9];
        visited = new boolean[9];
        res = 0;

        visited[0] = true;
        num[3] = 0;

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(res);

    }
}
