import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i =0;i<M;i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);
            int res =0;

            for(int i =0;i<N;i++){
                int l =0;
                int r =M;

                while(l!=r){
                    int m = l + (r-l)/2;
                    if(A[i] > B[m]){
                        l = m+1;
                    }
                    else{
                        r = m;
                    }
                }
                res +=r;

            }
            System.out.println(res);
        }
    }
}
