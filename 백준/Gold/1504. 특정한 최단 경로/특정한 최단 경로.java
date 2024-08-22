import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w){
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return o.w - w;
    }
}

public class Main {
    public static int N,E;
    public static int V1,V2;
    public static int INF = 10000000;
    public static ArrayList<ArrayList<Node>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for(int i = 0; i < N+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Node(b, c));
            arr.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int res1 = dk(1,V1) + dk(V1,V2) + dk(V2,N);
        int res2 = dk(1,V2) + dk(V2,V1) + dk(V1,N);
        if(Math.min(res1,res2) >= INF){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(res1,res2));
        }

    }

    public static int dk(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int [] dist = new int[N+1];
        for(int i =0;i<N+1;i++){
            dist[i] = INF;
        }
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(int i =0 ;i< arr.get(cur.e).size();i++){
                int nxt_dist =arr.get(cur.e).get(i).w - cur.w;
                int n_node = arr.get(cur.e).get(i).e;

                if(nxt_dist < dist[n_node]){
                    dist[n_node] = nxt_dist;
                    pq.offer(new Node(n_node,-dist[n_node]));
                }
            }
        }
        return dist[end];
    }
}
