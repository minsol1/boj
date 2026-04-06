
import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,x,y ;
    public static int[] xarr;
    public static int[] yarr;
    public static long[] xsum;
    public static long[] ysum;

    public static long sum (int[] arr ,long[] sum, int num){

        int l = 0;
        int r = N-1;
        int idx = -1;

        while(l<=r){
            int m = r- (r-l)/2;

            if(arr[m]<=num){
                l = m+1;
                idx = m;
            }
            else{
                r = m-1;
            }
        }

        int cnt = idx +1;


        return (cnt)*num- sum[cnt] + sum[N]-sum[cnt] - (N-cnt)*num;


    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = 0;
        y = 0;

        xarr = new int[N];
        yarr = new int[N];
        xsum = new long[N+1];
        ysum = new long[N+1];

        for(int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            xarr[i]= a;
            yarr[i]= b;
        }

        Arrays.sort(xarr);
        Arrays.sort(yarr);

        for(int i = 1; i< N+1; i++){
            xsum[i] = xsum[i-1] + xarr[i-1];
            ysum[i] = ysum[i-1] + yarr[i-1];
        }


        String cmd = br.readLine();
        for(int i =0; i< M; i++){
            long res=0;
            char c = cmd.charAt(i);
            if(c == 'I'){
                x++;
            }
            if(c == 'Z'){
                x--;
            }
            if(c == 'S'){
                y++;
            }
            if(c == 'J'){
                y--;
            }

            res += sum(yarr, ysum, y);
            res += sum(xarr, xsum, x);

            System.out.println(res);


        }
    }
}
