import java.io.*;
import java.util.*;


public class Main {
    public static int N;
    public static int[] arr;
    public static int[] res;

    public static void dfs(int idx, int sum){
        if(idx == N) {
            if(sum >=0) res[sum]++;
            return;
        }

        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum-arr[idx]);
        dfs(idx+1, sum);

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }
        res = new int[M+1];

        dfs(0,0);
        int cnt = 0;

        for(int i =1; i<M+1; i++){
            if(res[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }
}
