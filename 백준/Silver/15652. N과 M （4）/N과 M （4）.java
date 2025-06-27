import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[]arr;
    public static StringBuilder sb;

    public static void dfs(int idx, int cnt){
        if(cnt==M){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = idx ; i<N+1;i++){
            arr[cnt]=i;
            dfs(i, cnt+1);
        }

    }


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr=new int[M];
        sb = new StringBuilder();

        dfs(1,0);

        System.out.println(sb);
    }
}
