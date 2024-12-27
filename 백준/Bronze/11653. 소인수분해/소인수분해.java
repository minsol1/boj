import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] prime=new boolean[N+1];
        prime[0] = true;
        prime[1] = true;

        for(int i = 2 ; i<N;i++){
            if(!prime[i]){
                for(int j = i*2 ; j<N+1; j+=i){
                    prime[j] = true;
                }
            }
        }

        int i = 2;
        while(N!=1){
            if(N%i==0){
                N/=i;
                System.out.println(i);
            }
            else{
                i++;
            }
        }

    }
}
