import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int s;
    int e;
    int w;

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
    public Node(int s,int e,int w){
        this.s =s;
        this.e =e;
        this.w =w;

    }
}
public class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int res = 0;

        parent = new int[N+1];
        Node[] arr = new Node[M];

        for(int i =0;i<N+1;i++){
            parent[i] = i;
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[i] = new Node(s,e,w);

        }

        Arrays.sort(arr);

        int cnt = 0;
        int idx =0;
        while(cnt<N-2){
            Node now = arr[idx++];

            if(check(now.s, now.e)){
                continue;
            }

            union(now.s,now.e);
            res += now.w;
            cnt++;
        }

        System.out.print(res);

    }

    public static int find(int x){
        if(parent[x]==x){
            return x;

        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int u, int v){
        int x = find(u);
        int y = find(v);

        if(x == y){
            return;
        }
        if(x<y){
            parent[y]=x;
        }
        else{
            parent[x] = y;
        }
    }

    public static boolean check(int u,int v){
        int x = find(u);
        int y = find(v);

        return x == y;
    }
}
