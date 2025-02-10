import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int res =0;

        String str = br.readLine();

        for(int i =0;i<N;i++){
            arr[i]= str.charAt(i);
        }
        for(int i =0;i<N;i++){
            if(arr[i] == 'P'){
                for(int j = i-K; j<=i+K;j++){
                    if(j>=0 && j<N){
                        if(arr[j]=='H'){
                            arr[j] = 'X';
                            res ++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
