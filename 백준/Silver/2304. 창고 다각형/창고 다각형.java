import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int minL=1000;
        int maxL =0;
        int maxH=0;
        int HIndex =0;
        int res =0;

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            minL = minL<L?minL:L;
            maxL = maxL>L? maxL:L;
            if(maxH<H){
                maxH = H;
                HIndex = L;
            }
        }
        int l = 0;

        for(int i =minL;i<HIndex;i++){
            if(arr[i]>l){
                l = arr[i];
            }
            res+=l;
        }
        l = 0;
        for(int i = maxL ; i>=HIndex ; i--){
            if(arr[i]>l){
                l = arr[i];
            }
            res+=l;
        }
        System.out.println(res);

    }
}
