import java.util.*;
import java.io.*;

class Solution
{
    
    public static int N, L, res;
    public static int[][] arr;
    
    public static void dfs(int n , int sum, int cal){
        if(cal > L) return;
        if(sum > res) res = sum;
        if(n == N) return;
        
        dfs(n+1,sum+ arr[n][0] ,cal + arr[n][1]);
        dfs(n+1,sum,cal);
        
    }
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            res = 0;
            
            arr= new int[N][2];
            
            for(int i =0; i< N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0,0,0);
            System.out.println("#"+test_case+" "+res);
            
		}
	}
}