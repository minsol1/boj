import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];
        StringBuilder sb = new StringBuilder();

        for(int i =1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1;j<N+1;j++){
                int n = Integer.parseInt(st.nextToken());

                sum[i][j]= sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+n;

            }
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int res = sum[x2][y2]- sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}
