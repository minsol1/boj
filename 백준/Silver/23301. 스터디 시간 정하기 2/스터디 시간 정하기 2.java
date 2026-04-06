
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] time = new int[1001];

        for(int i = 0; i< N; i++){
            int cnt = Integer.parseInt(br.readLine());

            for(int j = 0; j < cnt ; j++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());

                for(int s = S; s<E; s++){
                    time[s]++;
                }
            }

        }

        int s = 0;
        int e = T;
        int sum = 0;

        int res = 0;
        for(int i = s ; i < e; i++){
            sum += time[i];

        }
        int maxSum = sum;


        for(int i = 1; i <= 1000-e; i++){
            sum = sum - time[s + i - 1] + time[e + i -1 ];
            if(sum > maxSum){
                res = i;
                maxSum = sum;
            }
        }
        System.out.println(res +" "+ (e+res));
    }
}
