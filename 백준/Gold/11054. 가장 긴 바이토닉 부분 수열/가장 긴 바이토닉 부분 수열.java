import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp1 = new int[N+1]; // 증가
        int[] dp2 = new int[N+1]; // 감소
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1; i<N+1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //증가
        for(int i =1; i<N+1 ; i++){
            dp1[i] = 1;
            for(int j = i-1 ; j>=1 ; j--){
                if(arr[i] > arr[j]){
                    dp1[i] = dp1[i]> dp1[j]+1 ?dp1[i] : dp1[j]+1;
                }
            }
        }

        //감소
        for(int i =N; i>=1 ; i--){
            dp2[i] = 1;
            for(int j = i ; j<N+1 ; j++){
                if(arr[i] > arr[j]){
                    dp2[i] = dp2[i]> dp2[j]+1 ?dp2[i] : dp2[j]+1;
                }
            }
        }

        int res = 0;
        int idx = 0;

        for(int i =1; i<N+1 ; i++){
            res = res > dp1[i]+dp2[i] ?res : dp1[i]+dp2[i];
//            if(res <dp1[i]+dp2[i]){
//                res = dp1[i]+dp2[i];
//                idx = i;
//            }
        }

        System.out.println(res-1);
    }
}
