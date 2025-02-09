import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Queue<Character> q = new ArrayDeque<>();

        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);

            q.add(c);
        }

        int res =0;
        while(!q.isEmpty()){
            res++;
            for(int i=0;i< Integer.toString(res).length();i++){
                char c = Integer.toString(res).charAt(i);
                if(q.peek()==c){
                    q.poll();
                    if(q.isEmpty()) break;
                }
            }
        }
        System.out.print(res);

    }
}
