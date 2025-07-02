import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        sb.append('<');

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt =1;

        for(int i =1;i<=N;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            if(cnt%K==0){
                sb.append(q.poll());
                if(q.size()>0) sb.append(", ");
                else sb.append(">");
            }
            else{
                q.add(q.poll());
            }
            cnt++;
        }

        System.out.println(sb);


    }
}
