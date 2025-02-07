import java.util.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static int[] arr;

    public static boolean check(int m ){
        int total = 0;

        for(int i =0;i<N;i++){
            if(arr[i]>m){
                total+=m;
            }
            else{
                total+=arr[i];
            }
        }
        return (total<=M);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = 0;
        int r = 0;
        int res =0;

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            r = r > arr[i]?r : arr[i];
        }

        M = Integer.parseInt(br.readLine());

        while(l<=r){
            int m = (l+r)/2;

            if(check(m)){
                res = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        System.out.println(res);

    }
}
