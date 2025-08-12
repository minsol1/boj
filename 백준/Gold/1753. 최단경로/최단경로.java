import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int e;
    int w;

    public Node(int e , int w){
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return w-o.w;
    }

}
public class Main {

    public static int V,E,K;
    public static int[] dist;
    public static ArrayList[] arr;

    public static void bfs(int s){
        PriorityQueue<Node> pq =new PriorityQueue<>();
        dist[s]= 0;
        pq.add(new Node(s,0));

        while(!pq.isEmpty())
        {
            Node now = pq.poll();

            for(int i =0;i<arr[now.e].size();i++){
                Node nx = (Node)arr[now.e].get(i);
                int next_dest = nx.e;
                int next_dist = now.w+ nx.w;

                if(dist[next_dest] > next_dist){
                    dist[next_dest] = next_dist;
                    pq.add(new Node(next_dest, next_dist));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        arr = new ArrayList[V+1];

        for(int i =0;i<=V;i++){
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i =0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,w));
        }

        bfs(K);

        StringBuilder sb = new StringBuilder();
        for(int i =1; i<V+1; i++){
            if(dist[i]== Integer.MAX_VALUE)
                sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }

        System.out.print(sb);

    }
}
