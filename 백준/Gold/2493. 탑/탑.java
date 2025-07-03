import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<N+1;i++){
            int n = Integer.parseInt(st.nextToken());
            hm.put(n,i);

           while(!stack.isEmpty()){
               if(stack.peek()>n){
                   sb.append(hm.get(stack.peek())).append(" ");
                   break;
               }
               stack.pop();
           }
           if(stack.isEmpty()) sb.append(0).append(" ");

           stack.add(n);

        }

        System.out.println(sb);


    }
}
