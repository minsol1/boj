import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        int INF = 987654321;
        int res = INF;

        for(int i =0;i<N+1;i++){
            for(int j =0;j<N+1;j++){
                if(i!=j){
                    arr[i][j] = INF;
                }
            }
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[s][e]=w;
        }

        for(int i =1 ; i<N+1;i++){
            for(int j =1;j<N+1;j++){
                if(i==j) continue;

                for(int k =1;k<N+1;k++){
                    arr[i][j] = arr[i][j]<arr[i][k]+arr[k][j]?arr[i][j]:arr[i][k]+arr[k][j];
                }
            }
        }

        for(int i =1;i<N+1;i++){
            for(int j =1;j<N+1;j++){
                if(i==j) continue;
                if(arr[i][j]!=INF && arr[j][i]!=INF){
                    res = res < arr[i][j]+arr[j][i]?res : arr[i][j]+arr[j][i];
                }
            }
        }
        if(res==INF) res =-1;
        System.out.println(res);

    }
}
