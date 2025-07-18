import java.io.*;
import java.util.*;

public class Main {

    public static int N,res;
    public static boolean[][] arr;

    public static void dfs(int x){
        if(x == N){
            res ++;
        }

        for(int i =0;i<N;i++){
            if(is_pos(x,i)){
                arr[x][i] = true;
                dfs(x+1);
                arr[x][i] = false;
            }
        }
    }
    public static boolean is_pos(int x,int y){
        for(int i =0; i<N;i++){
            if(arr[i][y]) return false;
        }
        for(int i =0; i<N;i++){
            if(arr[x][i]) return false;
        }
        for(int i =0; i<N;i++){
            if(x-i >=0 && y-i>=0){
                if(arr[x-i][y-i]) return false;
            }
            if(x+i <N && y+i<N){
                if(arr[x+i][y+i]) return false;
            }
            if(x-i >=0 && y+i<N){
                if(arr[x-i][y+i]) return false;
            }
            if(x+i < N && y-i>=0){
                if(arr[x+i][y-i]) return false;
            }

        }

        return true;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res = 0;
        arr = new boolean[N][N];

        dfs(0);

        System.out.println(res);
    }
}
