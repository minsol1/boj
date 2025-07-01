import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> fstack = new Stack<>();
        Stack<Integer> bstack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int now =-1;

        for(int i =0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("B")){
                if(bstack.isEmpty() || now == -1) continue;
                fstack.add(now);
                now=bstack.pop();
            }
            if(cmd.equals("F")){
                if(fstack.isEmpty() || now == -1) continue;
                bstack.add(now);
                now=fstack.pop();
            }
            if(cmd.equals("A")){
                if(now!=-1){
                    bstack.add(now);
                }
                now = Integer.parseInt(st.nextToken());
                fstack.clear();
            }
            if(cmd.equals("C")){
                if(bstack.isEmpty()) continue;
                Stack<Integer> tmp = new Stack<>();
                int pre = -1;
                for(int n : bstack){
                    if(pre != n) {
                        tmp.add(n);
                        pre = n;
                    }
                }
                bstack.clear();
                for(int n : tmp){
                    bstack.add(n);
                }
            }
        }

        System.out.println(now);
        if(bstack.isEmpty()){
            System.out.println(-1);
        }
        else{
            while(!bstack.isEmpty())
                System.out.print(bstack.pop()+" ");
            System.out.println("");
        }

        if(fstack.isEmpty()){
            System.out.println(-1);
        }
        else{
            while(!fstack.isEmpty())
                System.out.print(fstack.pop()+" ");
            System.out.println("");
        }

    }
}
