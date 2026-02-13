
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int W = 0;
        int H = 0;
        int E = 0;
        int res = 0;

        for(int i =0; i< N; i++){
            char c = str.charAt(i);
            if(c == 'W' ) W++;
            else if(c=='H'){
                H = (H + W)%1_000_000_007;
            }
            else if(c == 'E') {
                if(E!=0){
                    res = (res + res)%1_000_000_007;
                    res = (res +E)%1_000_000_007;
                }
                E = (E + H)%1_000_000_007;

            }
//            System.out.println(W +" "+ H+ " "+E+ " "+res );
        }

        System.out.println(res);

    }
}
