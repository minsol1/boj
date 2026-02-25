
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = N;

        for(int i =0 ; i < N; i++){
            String str = br.readLine();
            HashSet<Character> hs = new HashSet<>();

            int idx = 0;
            while(idx < str.length()){
                char c = str.charAt(idx);

                if(hs.contains(c)){
                    res --;
                    break;
                }
                else {
                    hs.add(c);

                    while(idx < str.length() && str.charAt(idx) == c){
                        idx++;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
