import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int rank = 1;
        int cnt = 0;

        if(N > 0){
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                long num = Long.parseLong(st.nextToken());
                if(C < num) rank++;
                if(C <= num) cnt++;
            }
        }

        if(cnt >=P) rank = -1;

        System.out.println(rank);
    }
}
