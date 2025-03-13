import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int res = 0;
        int[] arr = new int[N];
        int[] cnt = new int[D+1];
        int c =1;
        cnt[C]++;
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i<K){
                cnt[arr[i]]++;
                if(cnt[arr[i]]==1){
                    c++;
                }
            }
        }
        res =c;
        int l = 0;
        int r = K-1;
        while(l != N-1){
            cnt[arr[l]]--;
            if(cnt[arr[l]]==0) c--;
            l = (l+1)%N;
            r = (r+1)%N;
            cnt[arr[r]]++;
            if(cnt[arr[r]]==1) c++;

            res = res > c ? res :c;

        }

        System.out.println(res);
    }
}
