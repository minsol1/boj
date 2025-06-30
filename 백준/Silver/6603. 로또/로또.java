import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int[] arr;
    public static int[] num;
    public static StringBuilder sb;

    public static void dfs(int idx, int cnt){
        if(cnt == 6){
            for(int n : num){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(idx==K) return;


        num[cnt]=arr[idx];
        dfs(idx+1,cnt+1);
        dfs(idx+1, cnt);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K==0) break;
            arr = new int[K];
            num = new int[6];
            for(int i =0;i<K;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
