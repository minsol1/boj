import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];// [지름길 수 ][출발, 도착, 길이]
        int [] dp =new int[D+1];

        for(int i =0;i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1;i<D+1;i++){
            dp[i] = dp[i-1]+1;

            for(int j =0;j<N;j++){
                if(arr[j][1]==i){
                    dp[i] =Math.min( dp[i],dp[arr[j][0]]+arr[j][2]);
                }
            }
        }

        System.out.print(dp[D]);

    }
}
