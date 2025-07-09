import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int s;
    int e;

    public Node(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Node o) {
        if(o.e==e){
            return s-o.s;
        }
        return e-o.e;
    }

}
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i =0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) ));

        }

        int res =0;
        int now =0;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.s>= now){
                res++;
                now = node.e;

            }
        }
        System.out.println(res);
    }
}
