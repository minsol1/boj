import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[][] dist = new int[N+2][N+2];
            int[][] pos = new int[N+2][2];

            for(int i =0; i<N+2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                pos[i][0]= a;
                pos[i][1]= b;
            }

            for(int i = 0; i< N+2; i++){
                for(int j = 0;j<N+2; j++){
                    int d = Math.abs(pos[i][0] - pos[j][0])+Math.abs(pos[i][1]- pos[j][1]);
                    dist[i][j]= d;
                }
            }

            for(int i =0; i<N+2; i ++){
                for(int j =0; j< N+2 ; j++){
                    for(int k =0; k<N+2; k++){
                        int d = Math.min(dist[j][k], dist[j][i] + dist[i][k]);

                        if(d <= 1000) dist[j][k] = 0;

                    }
                }
            }
            
            if(dist[0][N+1] >1000) System.out.println("sad");
            else System.out.println("happy");
        }
    }
}
