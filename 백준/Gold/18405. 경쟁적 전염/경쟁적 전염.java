import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int num;

    public Node(int x,int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Node o) {
        return this.num - o.num;
    }
}

public class Main {
    public static int N,K;
    public static int[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int S,X,Y;
    public static PriorityQueue<Node> queue;

    public static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int d = 0; d<4;d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];

                if(nx>=0 && nx<N && ny>=0&&ny<N && arr[nx][ny]==0){
                    arr[nx][ny] = now.num;
                    q.add(new Node(nx,ny, now.num));
                }
            }
        }
        queue = q;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        queue = new PriorityQueue<>();

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0){
                    queue.add(new Node(i,j,arr[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        while(S>0){
            bfs();
            S--;
        }

        System.out.println(arr[X-1][Y-1]);

    }
}
