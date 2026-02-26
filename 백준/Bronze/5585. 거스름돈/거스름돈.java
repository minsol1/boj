
import java.io.*;
import java.util.*;

public class Main {
    public static int[] coin = {500,100,50,10,5,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int res = 0;
        int idx = 0;

        while(N != 0){
            res += (N/coin[idx]);
            N %= coin[idx];
            idx++;
        }

        System.out.println(res);

    }
}
