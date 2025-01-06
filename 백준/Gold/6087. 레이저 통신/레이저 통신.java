import java.io.*;
import java.util.*;


    class Node{
        int x;
        int y;
        int d;
        int c;

        public Node(int x,int y, int d, int c){
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
public class Main {

    public static int N,M;
    public static char[][] arr;
    public static int[][][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int res = Integer.MAX_VALUE;
    public static int[][] pos;

    public static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,0,0));
        q.add(new Node(x,y,1,0));
        q.add(new Node(x,y,2,0));
        q.add(new Node(x,y,3,0));
        visited[x][y][0] = 0;
        visited[x][y][1] = 0;
        visited[x][y][2] = 0;
        visited[x][y][3] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d = 0; d<4;d++){
                int nx = now.x+dx[d];
                int ny = now.y+dy[d];
                if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]=='*') continue;
                int cnt = now.d==d?now.c:now.c+1;
                if(visited[nx][ny][d]>cnt){
                    visited[nx][ny][d] = cnt;
                    if(nx == pos[1][0]&& ny==pos[1][1]){
                        res = res<visited[nx][ny][d]?res:visited[nx][ny][d];
                    }
                    else{
                        q.add(new Node(nx,ny,d,cnt));
                    }
                }
            }
        }
    }

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr= new char[N][M];
        visited = new int[N][M][4];
        pos = new int[2][2];
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                visited[i][j][0] = Integer.MAX_VALUE;
                visited[i][j][1] = Integer.MAX_VALUE;
                visited[i][j][2] = Integer.MAX_VALUE;
                visited[i][j][3] = Integer.MAX_VALUE;
            }
        }

        int idx =0;
        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j = 0; j<M;j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j]=='C'){
                    pos[idx][0] =i;
                    pos[idx][1]=j;
                    idx++;
                }
            }
        }

        bfs(pos[0][0],pos[0][1]);

        System.out.println(res);
    }
}
