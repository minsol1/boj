import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    int r;
    int idx;

    public Node(int x, int y, int r, int idx){
        this.x =x;
        this.y =y;
        this.r =r;
        this.idx =idx;
    }
}
public class Main {

    public static int N;
    public static ArrayList<Node> arr;
    public static boolean[] visited;

    public static void bfs(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        visited[node.idx] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i =0 ; i<N;i++){
                if(visited[i]) continue;

                Node nx = arr.get(i);
                double dist = Math.sqrt( Math.pow( Math.abs(now.x - nx.x),2) + Math.pow(Math.abs(now.y - nx.y),2)) ;
                if(dist <= now.r + nx.r){
                    visited[nx.idx] = true;
                    q.add(nx);
                }
            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t = 0; t<T ;t++){
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            visited = new boolean[N];
            int res = 0;

            for(int i =0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                arr.add(new Node(x,y,r,i));
            }

            for(int i =0;i<N;i++){
                if(!visited[i]){
                    bfs(arr.get(i));
                    res++;
                }
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
