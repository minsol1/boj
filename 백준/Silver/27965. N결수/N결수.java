
import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static long[] arr;

    public static double cnt(int num){
        int c = 0;
        while(num!=0){
            c++;
            num /=10;
        }
        return c;

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N+1];

        for(int i =1; i< N+1 ; i++){
//            System.out.println(i+" "+ cnt(i)+" "+ (int)Math.pow(10,cnt(i)));
            arr[i] = (arr[i-1]*(long)Math.pow(10,cnt(i)) %K + i%K ) %K;
//            System.out.println(arr[i]);

        }
        System.out.println(arr[N]);


    }
}
