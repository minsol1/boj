import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long res = 3000000001L;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb= new StringBuilder();

        for(int i =0;i<N-2;i++){
            int l = i+1;
            int r = N-1;

            while(l<r){
                long total =arr[i]+arr[r]+arr[l];
                if(Math.abs(total)<res){
                    res = Math.abs(total);
                    sb = new StringBuilder();
                    sb.append(arr[i]).append(" ").append(arr[l]).append(" ").append(arr[r]);
                }
                if(total>0){
                    r--;
                }
                else if(total<0){
                    l++;
                }
                else{
                    break;
                }
            }
        }

        System.out.print(sb);

    }
}
