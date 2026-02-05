
import java.io.*;
import java.util.*;

public class Main {
    public static String str;
    public static String res;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        res = br.readLine();
        char[] alpha = new char[26];

        HashSet<Character> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);

            if(!hs.contains(c)){
                hs.add(c);
                sb.append(c);
                alpha[idx++] = c;
            }
        }
//        System.out.println(sb);

        int n = 0;
        while(idx < 26){
            char c = (char)((int)'A' + n);
            if(!hs.contains(c)){
                alpha[idx++] = c;
            }
            n++;
        }

        for(int i = 0; i< res.length(); i++){
            char c = res.charAt(i);
            System.out.print(alpha[(int)c - 65]);
        }
    }
}
