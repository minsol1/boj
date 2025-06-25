import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(s ==1){
                int j=n;
                while(j<=N){
                    arr[j] = arr[j]==0?1:0;
                    j+=n;
                }
            }

            if(s ==2){
                int j =0;
                while(true){
                    int r = n+j;
                    int l = n-j;
                    if(r >N || l<1) break;
                    if(arr[r]!=arr[l]) break;

                    arr[r] = arr[r]==0?1:0;
                    arr[l] = arr[r];
                    j++;
                }
            }

        }
        for(int i = 1 ; i<N+1 ; i++){
            if(i%20==1 && i>20) System.out.println("");
            System.out.print(arr[i]+" ");
            
        }

    }
}
