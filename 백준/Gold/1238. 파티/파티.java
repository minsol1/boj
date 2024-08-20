import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
        int node;
        int w;

        Node(int node, int w){
            this.node = node;
            this.w = w;
        }


        @Override
        public int compareTo(Node o) {
            return o.w-w;
        }
}

public class Main {

    public static int N,M,X;
    public static ArrayList<ArrayList<Node>> arrayList, RarrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        RarrayList = new ArrayList<>();

        for(int i =0;i<N+1;i++){
            arrayList.add(new ArrayList<Node>());
            RarrayList.add(new ArrayList<Node>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arrayList.get(s).add(new Node(e,t));
            RarrayList.get(e).add(new Node(s,t));
        }

        int[] dist1 = dk(arrayList);
        int[] dist2 = dk(RarrayList);

        int res=0;
        for(int i=1;i<N+1;i++){
            res = Math.max(dist1[i]+dist2[i],res);
        }
        System.out.println(res);

    }

    public static int[] dk(ArrayList<ArrayList<Node>> arr){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[N+1];
        for(int i =0; i <N+1;i++){
            dist[i] = 10000000;
        }
        dist[X] = 0;

        pq.add(new Node(X,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(int i =0; i<arr.get(now.node).size();i++){
                int nxt_dist = arr.get(now.node).get(i).w-now.w;
                int n_node = arr.get(now.node).get(i).node;

                if(nxt_dist< dist[n_node]){
                    dist[n_node] = nxt_dist;
                    pq.add(new Node(n_node,-dist[n_node]));
                }

            }
        }
        return dist;

    }
}
