import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = 2000000000;

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int ml = 0;
        int mr = 0;

        while(l<r){
            if(Math.abs(arr[l]+arr[r])<=res){
                res = Math.abs(arr[l]+arr[r]);
                ml = l;
                mr = r;
            }
            if(arr[l]+arr[r]>0){
                r--;
            }
            else if(arr[l]+arr[r]<0){
                l++;
            }else{
                break;
            }

        }

        System.out.print(arr[ml]+" "+arr[mr]);
    }
}
