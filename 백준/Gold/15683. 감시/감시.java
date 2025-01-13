
import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    int d;
    int n;

    public Node(int x,int y, int d, int n ){
        this.x = x;
        this.y = y;
        this.d = d;
        this.n = n;
    }
}
public class Main {

    public static int N,M;
    public static int[][] arr;
    public static int res =Integer.MAX_VALUE;
    public static ArrayList<Node> node;
    public static int[][][] dx = { {},
                                {{-1},{1},{0},{0}},
                                {{0,0},{1,-1}},
                                {{0,-1},{0,-1},{0,1},{0,1}},
                                {{0,1,0},{1,0,-1},{0,-1,0},{-1,0,1}},
                                {{0,1,0,-1}}};
    public static int[][][] dy = {{},
                                {{0},{0},{-1},{1}},
                                {{1,-1},{0,0}},
                                {{1,0},{-1,0},{1,0},{-1,0}},
                                {{1,0,-1},{0,-1,0},{-1,0,1},{0,1,0}},
                                {{1, 0, -1, 0}}};

    public static void dfs(int idx, ArrayList<Node> node){
        if(idx == node.size()){
            boolean[][] visited = new boolean[N][M];

            for(Node now : node){
                for(int d =0; d<dx[now.n][now.d].length;d++){
                    int nx = now.x+dx[now.n][now.d][d];
                    int ny = now.y+dy[now.n][now.d][d];
                    while(nx>=0 && nx<N && ny>=0 && ny<M){
                        visited[nx][ny] = true;
                        if(arr[nx][ny] ==6) break;
                        nx +=dx[now.n][now.d][d];
                        ny += dy[now.n][now.d][d];
                    }
                }
            }

            int cnt = 0;
            for(int i =0;i<N;i++){
                for(int j =0;j<M;j++){
                    if(!visited[i][j]&&arr[i][j]==0){
                        cnt++;
                    }
                }
            }
            res = res<cnt? res:cnt;

            return;

        }

        for(int i = 0 ;i< dx[node.get(idx).n].length;i++){
            node.get(idx).d = i;
            dfs(idx+1,node);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        node = new ArrayList<>();

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0){
                    if(arr[i][j]!=6) node.add(new Node(i,j,0,arr[i][j]));
                }
            }
        }

        dfs(0,node);

        System.out.println(res);
    }
}
