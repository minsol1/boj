import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        String[] str = new String[N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;i<M;i++){
            int n = Integer.parseInt(br.readLine());

            int l =0;
            int r = N-1;
            int res = 0;

            while(l<=r){
                int m = (l+r)/2;

                if(n<=arr[m]){
                    res = m;
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            sb.append(str[res]).append('\n');

        }
        System.out.println(sb);
    }
}
