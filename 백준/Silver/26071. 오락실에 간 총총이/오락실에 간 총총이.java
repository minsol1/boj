
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int xmin =1500;
        int xmax = 0;
        int ymin = 1500;
        int ymax = 0;

        for(int i =0; i< N; i++) {
            String str= br.readLine();

            for(int j = 0; j< N; j++){
                char c = str.charAt(j);
                if(c == 'G'){
                    xmin = xmin < i ? xmin : i;
                    xmax = xmax > i ? xmax : i;
                    ymin = ymin < j ? ymin : j;
                    ymax = ymax > j ? ymax : j;

                }
            }
            
        }

        int res = 0;

        if(xmin != xmax){
            int u = xmax;
            int d = N-1 -xmin;

            res += u <d ? u :d;
        }
        if(ymin != ymax){
            int l = ymax;
            int r = N-1 -ymin;

            res += l <r ? l :r;
        }

        System.out.println(res);
    }
}
