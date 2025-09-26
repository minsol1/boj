import java.io.*;
import java.util.*;

public class Main {

    public static int N,M;
    public static StringBuilder sb;

    public static void dfs(int c , int[] num){
        if(c == M){
            for(int s: num){
                sb.append(s).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1;i<=N;i++){

            num[c] = i;
            dfs(c+1,num);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        int[] num = new int[M];

        dfs(0,num);

        System.out.print(sb);
    }
}
