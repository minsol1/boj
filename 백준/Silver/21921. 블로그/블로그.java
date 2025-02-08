import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[]args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max =0;
        int cnt =1;
        int sum =0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i<M){
                sum+=arr[i];
            }
        }
        int l =0;
        int r = M;
        max = sum;

        while(r!=N){
            sum -= arr[l];
            sum+= arr[r];

            if(sum>max){
                max = sum;
                cnt=1;
            }
            else if(sum==max){
                cnt++;
            }
            l++;
            r++;
        }

        if(max == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
