import java.io.*;
import java.util.*;

public class Main {
    public static int N,blue, white;
    public static int[][] arr;

    public static void dfs(int x,int y, int n ){
        int p = arr[x][y];

        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(arr[x+i][y+j]!=p){
                    dfs(x,y,n/2);
                    dfs(x+n/2,y,n/2);
                    dfs(x,y+n/2,n/2);
                    dfs(x+n/2,y+n/2,n/2);
                    return;
                }
            }
        }
        if(p==1){
            blue++;
        }
        else{
            white++;
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        blue =0;
        white = 0;


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j =0;j<N;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,N);

        System.out.println(white);
        System.out.println(blue);

    }
}
