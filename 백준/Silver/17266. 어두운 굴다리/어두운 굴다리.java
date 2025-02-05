import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] pos;

    public static boolean check(int m){
        int pre = 0;

        for(int i =0;i<M;i++){

            if(pos[i]-m <=pre){
                pre = pos[i]+m;
            }
            else{
                return false;
            }
        }
        return pre>=N;

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        pos  = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            int n = Integer.parseInt(st.nextToken());
            pos[i] = n;
        }

        int l =1;
        int r = N;
        int res =0 ;
        while(l<=r){
            int m = (r+l)/2;
            if(!check(m)){
                l =m+1;
            }
            else{
                res = m;
                r = m-1;
            }
        }

        System.out.print(res);
    }
}
