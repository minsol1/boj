import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{

    int n;

    public Node(int n ){
        this.n = n;
    }

    @Override
    public int compareTo(Node o) {
        if(Math.abs(o.n)==Math.abs(n)){
            return n-o.n;
        }
        return Math.abs(n)-Math.abs(o.n);
    }
}
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());

            if(n!=0){
                pq.add(new Node(n));
            }
            else{
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }
                else sb.append(pq.poll().n).append('\n');
            }
        }

        System.out.println(sb);
    }
}
