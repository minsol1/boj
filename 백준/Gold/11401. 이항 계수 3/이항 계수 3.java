import java.io.*;
import java.util.*;

public class Main {
    public static int D = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 분자 N!
        long numer = factorial(N);

        // 분모 (K! * (N-K)!) mod p
        long denom = factorial(K) * factorial(N - K) % D;


        // N! * 분모의 역((K! * (N-K)!)
        System.out.println(numer * pow(denom, D - 2) % D);
    }
    public static long factorial(long N) {
        long fac = 1L;

        while(N > 1) {
            fac = (fac * N) % D;
            N--;
        }
        return fac;
    }

    public static long pow(long base, long expo) {
        if(expo == 1) {
            return base % D;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % D) * base % D;
        }
        return temp * temp % D;

    }
}
