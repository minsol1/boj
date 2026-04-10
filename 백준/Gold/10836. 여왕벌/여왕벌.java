
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] res = new int[M][M];
        int[] sum = new int[M*2 -1];
        Arrays.fill(sum, 1);
        StringBuilder sb= new StringBuilder();

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            for(int j =0; j<3; j++){
                int K = Integer.parseInt(st.nextToken());
                for(int k =0; k<K; k++){
                    sum[idx++] += j;
                }
            }
        }

        for(int i =0; i< M; i++){
            for(int j =0; j< M;j++){
                if(i == 0 || j == 0){
                    res[i][j] = sum[(M-i-1)+j];
                }
                else{
                    res[i][j] = Math.max(res[i-1][j-1], Math.max(res[i-1][j],res[i][j-1]));
                }
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);

    }
}
