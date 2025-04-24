import java.io.*;
import java.util.*;

public class Main {
    public static int N,K,P,X;
    public static boolean[][] num = {{true,true,true,true,true,true,false},//0
                                    {false,true,true,false,false,false,false}, // 1
                                    {true,true,false,true,true,false,true}, //2
                                    {true,true,true,true,false,false,true},//3
                                    {false,true,true,false,false,true,true},//4
                                    {true,false,true,true,false,true,true},
                                    {true,false,true,true,true,true,true},
                                    {true,true,true,false,false,false,false},
                                    {true,true,true,true,true,true,true},
                                    {true,true,true,true,false,true,true}};
    public static int[] xnum;
    public static int res;

    public static void check(){
        for(int i =1; i<=N;i++){
            if(i==X) continue;

            int[] d = to_digit(i);

            if(cnt(d)){
                res++;
            }

        }

    }
    public static boolean cnt(int[] d){
        int c =0;
        for(int i =0;i<K;i++){
            for(int j =0;j<7;j++){
                if(num[d[i]][j]!= num[xnum[i]][j]) c++;
                if(c>P) return false;
            }
        }
        return true;
    }
    public static int[] to_digit(int n){
        int i =1;
        int[] d = new int[K];
        while(n>0|| i<=K){
            d[K-i] = n%10;
            n /=10;
            i++;
        }
        return d;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        res =0;

        xnum = to_digit(X);

        check();

        System.out.println(res);

    }
}