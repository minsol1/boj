
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        HashMap<Long,Integer> hm = new HashMap<>();

        long[] arr = new long[N+1];
        long res = 0;

        st = new StringTokenizer(br.readLine());
        for(int i =1; i< N+1; i++){
            long n =  Long.parseLong(st.nextToken());
            arr[i] = n;
            arr[i] += arr[i-1];
            Long find = arr[i] - K;

            res += hm.getOrDefault(find,0);
            if( arr[i] == K) res ++;
//            System.out.println(arr[i]+" "+ find +" "+ hm.getOrDefault(find,0)  );

            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1);


        }

        System.out.println(res);


    }
}
