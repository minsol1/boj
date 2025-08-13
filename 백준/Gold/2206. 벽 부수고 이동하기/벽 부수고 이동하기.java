import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    int w;

    public Node(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

public class Main {

    public static int N,M;
    public static int[][] arr;
    public static int[][][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0][0] = 1;
        q.add(new Node(0,0,0));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx < 0 || nx>=N || ny <0 || ny >=M)
                    continue;

                if(arr[nx][ny] == 1){
                    if(visited[nx][ny][1] ==0 && now.w ==0 ){
                        q.add(new Node(nx,ny,1));
                        visited[nx][ny][1] = visited[now.x][now.y][0]+1;
                    }
                    continue;
                }

                if(visited[nx][ny][now.w] == 0){
                    q.add(new Node(nx,ny,now.w));
                    visited[nx][ny][now.w] = visited[now.x][now.y][now.w]+1;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M][2];

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<M;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if(visited[N-1][M-1][0] == 0 &&  visited[N-1][M-1][1]==0)
            System.out.println(-1);
        else if (visited[N-1][M-1][0] == 0 ||  visited[N-1][M-1][1]==0)
            System.out.println(Math.max(visited[N-1][M-1][0], visited[N-1][M-1][1]));
        else
            System.out.println(Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]));
    }
}
