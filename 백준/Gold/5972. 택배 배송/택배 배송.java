import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int d;
    int c;

    public Node(int d, int c){
        this.c = c;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        return c-o.c;
    }
}

public class Main {


    public static int N,M;
    public static ArrayList<Node>[] arr;
    public static int[] dist;
    public static int INF =50000001;

    public static void dijk(int start){
        for(int i =0; i<N+1;i++){
            dist[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cost = cur.c;
            int dest = cur.d;

            for(int i =0;i<arr[dest].size();i++){
                int ndist = cost + arr[dest].get(i).c;

                if(ndist < dist[arr[dest].get(i).d]){
                    pq.add(new Node(arr[dest].get(i).d,ndist));
                    dist[arr[dest].get(i).d]= ndist;
                }

            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        dist = new int[N+1];


        for(int i =0;i<N+1;i++){
            arr[i] = new ArrayList<>();
            arr[i].add(new Node(i,0));
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));

        }

        dijk(1);

        System.out.print(dist[N]);

    }
}
