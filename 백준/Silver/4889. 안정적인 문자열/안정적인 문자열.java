
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while(true){
            String str = br.readLine();
            int res = 0;
            if(str.charAt(0) == '-') break;

            Stack<Character> stack = new Stack<>();

            for(int i =0; i< str.length(); i++){
                char c = str.charAt(i);

                if(c == '{'){
                    stack.add(c);
                }
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        stack.add(c);
                        res++;
                    }
                }
            }
            if(!stack.isEmpty()) res += stack.size()/2;

            System.out.println(t+". "+res);
            t++;

        }
    }
}
