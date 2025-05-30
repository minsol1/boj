import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d =1_000_000_000;
        int[] dp = new int[Math.abs(N)+1];
        if(N<0){
            dp[1]=1;
            for(int i =2;i<Math.abs(N)+1;i++){
                int n = dp[i-2]-dp[i-1];
                if(n<0){
                    dp[i] = -1*(-1*n)%d;
                }
                else{
                    dp[i] =(n)%d;
                }

            }
        }
        else if(N>0){
            dp[1]=1;
            for(int i =2;i<Math.abs(N)+1;i++){
                dp[i] = (dp[i-1]+dp[i-2])%d;
            }
        }

        if(dp[Math.abs(N)]<0){
            System.out.println(-1);
        }
        else if(dp[Math.abs(N)]>0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }


        System.out.println(Math.abs(dp[Math.abs(N)]));
        

    }
}
