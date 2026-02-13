
import java.io.*;
import java.util.*;

public class Main {
    public static int T, N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 0; t<T;t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int odd = 0;
            int even = 0;

            for(int i = 0 ; i<N; i++){
                int n = Integer.parseInt(st.nextToken());

                if(n %2 == 0) even++;
                else odd++;
            }

            int big = odd > even ? odd : even;

            if(odd == even) System.out.println("heeda0528");
            else if(big %2 == 0) System.out.println("heeda0528");
            else System.out.println("amsminn");
        }

    }
}
