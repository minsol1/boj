import java.io.*;
import java.util.*;

public class Main {

    public static int N,R,C,res;

    public static void dfs(int x,int y, int n){
        if(n == 1) return;
        if(x <n/2 && y <n/2){
            dfs(x,y,n/2);
        }
        else if(x <n/2 && y >=n/2){
            res+= n*n/4;
            dfs(x,y-n/2,n/2);
        }
        else if(x >=n/2 && y <n/2){
            res+= n*n/2;
            dfs(x-n/2,y,n/2);
        }
        else if(x >=n/2 && y >=n/2){
            res+= (n*n/4)*3;
            dfs(x-n/2,y-n/2,n/2);
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2,N);
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        res = 0;

        dfs(R,C,N);

        System.out.println(res);
    }
}
