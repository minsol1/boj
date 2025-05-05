import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int l = 1;
        int r = 1;
        int sum =1;
        int res =0;

        while(l<=r){
            if(sum>N){
                sum-=l;
                l++;
                continue;
            }
            if(sum<N){
                r++;
                sum+=r;
                continue;
            }
            if(sum==N) {
                res++;
                sum-=l;
                l++;
            }
        }

        System.out.println(res);
    }
}