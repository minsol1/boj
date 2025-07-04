import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int cost;

    public Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost -o.cost;
    }
}

public class Main {

    public static int N,M,S,E;
    public static ArrayList[] arr;
    public static int[] cost;

    public static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(S,0));
        cost[S] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.num==E) return;

            for(int i = 0; i<arr[now.num].size(); i++){
                Node next = (Node)arr[now.num].get(i);
                int nc = now.cost + next.cost;

                if(cost[next.num] >nc){
                    cost[next.num] = nc;
                    q.add(new Node(next.num,nc));
                }
            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        arr = new ArrayList[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        StringTokenizer st;

        for(int i =0;i<N+1;i++){
            arr[i] = new ArrayList<Node>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b,c));

        }
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(cost[E]);

    }
}
