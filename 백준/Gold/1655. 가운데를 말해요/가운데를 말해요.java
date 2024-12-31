import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mid = 0;
        PriorityQueue<Integer> lq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(i == 0){
                mid = num;
            }
            else if(num>mid){
                rq.add(num);
                if(rq.size()-lq.size()>1){
                    lq.add(mid);
                    mid = rq.poll();
                }
            }
            else if(num<mid){
                lq.add(num);
                if(lq.size()>rq.size()){
                    rq.add(mid);
                    mid = lq.poll();
                }
            }
            else{
                if(lq.size() > rq.size()){
                    lq.add(num);
                }
                else{
                    rq.add(num);
                }
            }

            sb.append(mid).append('\n');
        }
        System.out.println(sb);
    }
}
