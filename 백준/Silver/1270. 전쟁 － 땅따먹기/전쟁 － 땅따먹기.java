
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            HashMap<Long,Integer> hm = new HashMap<>();
            long win=-1;
            boolean f = false;

            for(int i =0; i< N; i++){
                long n = Long.parseLong(st.nextToken());

                hm.put(n, hm.getOrDefault(n,0)+1);

                if(hm.get(n) > N/2){
                    win = n;
                    f = true;
                    break;
                }
            }
            if(f){
                System.out.println(win);
            }
            else System.out.println("SYJKGW");


        }
    }
}
