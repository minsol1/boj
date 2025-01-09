import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]> product = new ArrayList<>();
        int[] dp = new int[M+1];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; k > 0; j++) {		// bitmasking을 이용하여 저장,
                int tmp = Math.min(1 << j, k);
                int curWeight = v * tmp;
                int curHappy = c * tmp;
                product.add(new int[] { curWeight, curHappy });
                k -= tmp;
            }
        }

        for (int i = 0; i < product.size(); i++) {			// 배낭문제랑 똑같이 dp돌림
            for (int j = M; j >= product.get(i)[0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - product.get(i)[0]] + product.get(i)[1]);

            }
        }
        System.out.println(dp[M]);


    }
}
