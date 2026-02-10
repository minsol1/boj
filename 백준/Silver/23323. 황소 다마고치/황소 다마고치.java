import java.io.*;
import java.util.*;

public class Main {

    public static long day(long num){
        int c = 0;
        while(num != 0){
            c++;
            num/=2;
        }

        return c;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()); //황소 체력
            long m = Long.parseLong(st.nextToken());// 먹이 수

            System.out.println(day(n) + m);
        }

    }
}
