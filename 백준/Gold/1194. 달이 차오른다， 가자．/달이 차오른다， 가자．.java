import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    int k;

    public Node(int x, int y, int k){
        this.x =x;
        this.y =y;
        this.k =k;
    }
}

public class Main {
    public static char[][] arr;
    public static int N,M,res;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int[][][] visited;
    public static Queue<Node> q;


    public static void bfs(){

        while(!q.isEmpty()){
            Node now = q.poll();
            if(arr[now.x][now.y] == '1'){
                res = visited[now.x][now.y][now.k];
                return;
            }

            for(int d = 0; d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx < 0 || nx >=N || ny < 0 || ny >=M || visited[nx][ny][now.k]!=-1 || arr[nx][ny] == '#') continue;
                if(arr[nx][ny] >= 'A'  && arr[nx][ny]<= 'F'){
                    int c = 1<<(arr[nx][ny] - 'A' +1);
                    if( (c & now.k )== 0) continue;
                }
                int k = now.k;
                if(arr[nx][ny] >= 'a'  && arr[nx][ny]<= 'f'){
                    int c =1<< (arr[nx][ny] - 'a'+1 );
                    k = k | c;
                }

                q.add(new Node(nx,ny,k));
                visited[nx][ny][k]= visited[now.x][now.y][now.k] +1;

            }
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();
        res = Integer.MAX_VALUE;

        arr = new char[N][M];
        visited = new int[N][M][1<<6+1];

        for(int i =0;i<N;i++){
            for(int j =0; j<M;j++){
                Arrays.fill(visited[i][j], -1);
            }
        }

        for(int i =0; i<N;i++){
            String str = br.readLine();

            for(int j =0; j<M;j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j]=='0') {
                    q.add(new Node(i,j,0));
                    visited[i][j][0] = 0;
                }
            }
        }

        bfs();

        if(res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);
    }
}
