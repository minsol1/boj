import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x =0;
        int y =0;
        if(H%(N+1)==0){
            x = H/(N+1);
        }
        else{
            x = H/(N+1)+1;
        }

        if(W%(M+1)==0){
            y = W/(M+1);
        }
        else{
            y = W/(M+1)+1;
        }
        System.out.print(x*y);

    }

}
