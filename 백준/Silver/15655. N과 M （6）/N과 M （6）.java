import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[] arr;
    public static StringBuilder sb;

    public static void dfs(int idx, int cnt, int[] res){
        if(cnt == M){
            for(int num : res){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i =idx; i<N ; i++){
            res[cnt] = arr[i];
            dfs(i +1, cnt+1, res);
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0,new int[M]);

        System.out.println(sb);

    }
}
