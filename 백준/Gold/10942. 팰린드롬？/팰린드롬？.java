import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[][] dp = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =N-1;i>=0;i--){
            for(int j =i;j<N;j++){
                int S = i;
                int E = j;
                if(S==E){
                    dp[S][E] = true;
                }
                else if(E-S==1){
                    if(arr[S]==arr[E]){
                        dp[S][E] = true;
                    }
                }
                else{
                    dp[S][E] = (arr[S]==arr[E])&dp[S+1][E-1];

                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i =0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken())-1;
            int E = Integer.parseInt(st.nextToken())-1;

            if(dp[S][E]){
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }

        }
        
        System.out.print(sb);

    }
}
