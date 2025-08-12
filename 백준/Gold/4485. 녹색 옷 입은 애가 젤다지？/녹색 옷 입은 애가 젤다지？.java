import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int c;

    public Node(int x, int y, int c){
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public int compareTo(Node o){
        return c-o.c;
    }
}

public class Main {

    public static int N;
    public static int[][] arr;
    public static int[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void bfs(){
        visited[0][0] = arr[0][0];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,visited[0][0]));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d =0;d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx <0 || nx >=N || ny <0 || ny >=N) continue;

                if(visited[nx][ny] > now.c + arr[nx][ny]){
                    visited[nx][ny] = now.c + arr[nx][ny];
                    q.add(new Node(nx,ny, now.c + arr[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int t =1;

        while(N!=0){
            arr = new int[N][N];
            visited = new int[N][N];

            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs();

            System.out.println("Problem "+t+": "+ visited[N-1][N-1]);
            N = Integer.parseInt(br.readLine());
            t++;
        }
    }
}
