import java.io.*;
import java.util.*;

public class Main {
    public static String S,T;
    public static boolean b;

    public static void dfs(String s){
        if(b) return;
        if(s.length() < S.length()){
            return;
        }
        if(s.length() == S.length()){
            for(int i =0;i<s.length();i++){
                if(s.charAt(i)!= S.charAt(i)){
                    return;
                }
            }
            b = true;
            return;
        }

        if(s.charAt(s.length()-1)=='A'){
            dfs(s.substring(0,s.length()-1));
        }
        if(s.charAt(0)=='B'){
            StringBuilder sb = new StringBuilder( s.substring(1));
            dfs(sb.reverse().toString());
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        if(b){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }

    }
}
