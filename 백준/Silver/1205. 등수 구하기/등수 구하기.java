import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int lank=1;
        int cnt=0;

        if(N>0) st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++ ){
            long n = Long.parseLong(st.nextToken());

            if(n>=S){
                cnt++;
                if(n>S){
                    lank++;
                }
            }

        }
        if(cnt>=P){
            System.out.print(-1);
        }
        else{
            System.out.print(lank);
        }
    }
}
