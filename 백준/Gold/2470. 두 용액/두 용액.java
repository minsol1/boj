import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int res = 2000000001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = N-1;
        int ml=0;
        int mr=0;
        while(l<r){
            int num = arr[l]+ arr[r];
            if(Math.abs(num) < res){
                res = Math.abs(num);
                ml = l;
                mr = r;
            }
            if(num<0){
                l++;
            }
            else if(num>0){
                r--;
            }
            else{
                break;
            }
        }

        System.out.print(arr[ml]+" "+arr[mr]);
    }
}
