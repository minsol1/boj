import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = getGcd(Math.max(a,b), Math.min(a,b));

        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i<gcd;i++){
            sb.append("1");
        }

        System.out.print(sb);
    }

    public static long getGcd(long a, long b){
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}
