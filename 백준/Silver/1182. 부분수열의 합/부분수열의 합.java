import java.io.*;
import java.util.*;

public class Main {
    public static int N , S,res;
    public static int[] arr;

    public static void dfs(int idx, int sum, int cnt){
        if(idx == N){
            if(sum == S && cnt >0) res++;
            return;
        }

        dfs(idx+1, sum+arr[idx], cnt+1);
        dfs(idx+1, sum,cnt);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        res = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0,0);
        System.out.println(res);
    }
}
