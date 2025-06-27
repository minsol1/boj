import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[]arr;
    public static StringBuilder sb;

    public static void dfs(int[]arr,int idx, int cnt){
        if(cnt==M){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        if(idx >N) return;

        arr[cnt]=idx;
        dfs(arr,idx+1, cnt+1);
        dfs(arr,idx+1, cnt);

    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr=new int[M];
        sb = new StringBuilder();

        dfs(arr,1,0);

        System.out.println(sb);
    }
}
