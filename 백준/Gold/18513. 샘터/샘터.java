
import java.io.*;
import java.util.*;

class Node{
    int num;
    long dist;

    public Node(int num , long dist){
        this.num = num;
        this.dist = dist;
    }
}

public class Main {
    public static int N, K,cnt;
    public static long res;
    public static HashSet<Integer> hs;
    public static Queue<Node> q;
    public static int[] dx= {1,-1};

    public static void bfs(){

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d <2; d++){
                int nx = now.num + dx[d];

                if(!hs.contains(nx) && cnt < K){
                    hs.add(nx);
                    q.add(new Node(nx, now.dist+1));
                    cnt++;
                    res += (now.dist+1);
                }
            }

        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        hs = new HashSet<>();
        q = new ArrayDeque<>();
        res = 0;
        cnt = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< N ; i++){
            int n = Integer.parseInt(st.nextToken());
            hs.add(n);
            q.add(new Node(n, 0));
        }

        bfs();

        System.out.println(res);


    }
}
