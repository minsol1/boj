import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l =0;
        int r=N-1;
        int cnt=0;

        while(l<r){
            int sum = arr[l]+arr[r];

            if(sum>M){
                r--;
                continue;
            }
            if(sum<M){
                l++;
                continue;
            }
            cnt++;
            l++;

        }

        System.out.println(cnt);

    }
}
