import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i =1;i<=N;i++){
            q.add(i);
        }
        int cnt=1;
        while(q.size()>1){
            if(cnt%2==1){
                q.poll();
            }
            else{
                q.add(q.poll());
            }
            cnt++;
        }

        System.out.println(q.peek());
    }
}
