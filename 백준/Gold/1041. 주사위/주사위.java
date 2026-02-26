
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[] arr = new long[6]; // 주사위
        long[] min = new long[3];
        Arrays.fill(min, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< 6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i< 6 ; i++){
            min[0] = min[0] < arr[i] ? min[0] : arr[i];
        }

        for(int i =0; i< 6 ; i++){
            for(int j = i+1; j<6; j++){
                if(i + j != 5){
                    min[1] = min[1] < arr[i]+ arr[j] ?min[1] : arr[i]+ arr[j] ;
                }
            }
        }

        min[2] = 0;
        for(int i = 0 ; i< 3; i++){
            min[2] += (arr[i] < arr[5-i] ? arr[i] : arr[5-i]);
        }

        long res = 0;
        if(N == 1){
            long max = 0;
            int sum =0;
            for(int i =0; i< 6; i++){
                sum += arr[i];
                max = max > arr[i] ? max : arr[i];
            }
            res = (sum-max);
        }
        else if(N == 2){
            res = min[2]*4 + min[1]*4;
        }
        else{
            res += min[2]*4;
            res += (4*(N-2) + (N-2)*(N-2)*5) * min[0];
            res += (8 * (N-2) + 4) * min[1];
        }

        System.out.println(res);


    }
}
