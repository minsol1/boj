import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for(int i =0; i< N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                if(b!=0) stack.add(b);
                continue;
            }
            if(stack.peek()>b){
                while(!stack.isEmpty()&&stack.peek()>b){
                    res++;
                    stack.pop();
                }
                if(b == 0){
                    continue;
                }
                if(stack.isEmpty()||stack.peek()!= b){
                    stack.add(b);
                }
                continue;
            }
            if(stack.peek()<b){
                stack.add(b);
            }
        }
        System.out.println(res+stack.size());
    }
}
