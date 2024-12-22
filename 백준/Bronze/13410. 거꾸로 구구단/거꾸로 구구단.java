import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res =0;

        for(int i =1;i<K+1;i++){
            String str = Integer.toString(i*N);
            int num=0;
            for(int j = str.length()-1 ; j>=0 ;j--){
                int n = str.charAt(j)-'0';
                num*=10;
                num+=n;
            }
            if(num>res){
                res = num;
            }
        }
        System.out.print(res);
    }
}
