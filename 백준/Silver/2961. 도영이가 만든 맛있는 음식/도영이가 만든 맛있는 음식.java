import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] sarr;
    public static int[] barr;
    public static int res = Integer.MAX_VALUE;

    public static void dfs(int s, int b ,int c,int idx){
        if(c >0 && idx==N){
            res = Math.abs(s-b)< res? Math.abs(s-b): res;
            return;
        }
        if(idx>=N) return;

        dfs (s,b,c,idx+1);
        dfs(s*sarr[idx], b+barr[idx], c+1, idx+1);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sarr = new int[N];
        barr = new int[N];

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sarr[i] = Integer.parseInt(st.nextToken());
            barr[i] = Integer.parseInt(st.nextToken());

        }

        dfs(1,0,0,0);

        System.out.println(res);

    }
}
