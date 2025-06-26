import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static boolean getPrime(int n){
        if(n<2) return false;
        for(int i=2; i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void dfs(int n, int c){
        if(c!=0 && !getPrime(n)) return;

        if (c == N) {
            System.out.println(n);
            return;
        }

        for(int i=0;i<10;i++){
            dfs(n*10+i,c+1);
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(0,0);


    }
}
