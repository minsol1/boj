import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int N,M;
    public static char[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static boolean[][] visited;
    public static boolean[] keys;
    public static ArrayList<Node>[] door;
    public static int res;

    public static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new Node(0,0));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int d= 0; d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx<0 || nx>=N+2 || ny<0 || ny>=M+2|| visited[nx][ny]|| arr[nx][ny]=='*'){
                    continue;
                }
                if(arr[nx][ny] == '.'){
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
                if(arr[nx][ny]>='a' && arr[nx][ny]<='z'){
                    keys[arr[nx][ny]-'a']=true;
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                    for(Node n : door[arr[nx][ny]-'a']){
                        visited[n.x][n.y] = true;
                        arr[n.x][n.y] ='.';
                        q.add(new Node(n.x, n.y));
                    }
                }
                if(arr[nx][ny]>='A' && arr[nx][ny]<='Z'){
                    if(keys[arr[nx][ny]-'A']){
                        arr[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new Node(nx,ny));
                    }
                    else{
                        door[arr[nx][ny]-'A'].add(new Node(nx,ny));
                    }
                }

                if(arr[nx][ny] == '$'){
                    res++;
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N+2][M+2];
            visited = new boolean[N+2][M+2];
            keys = new boolean[26];
            door = new ArrayList[26];
            res = 0;

            for(int i =0;i<26;i++){
                door[i] = new ArrayList<>();
            }

            for(int i =0;i<N+2;i++){
                for(int j =0; j<M+2;j++){
                    arr[i][j] = '.';
                }
            }

            for(int i =0;i<N;i++){
                String str = br.readLine();
                for(int j =0;j<M;j++){
                    arr[i+1][j+1] = str.charAt(j);
                }
            }
            String str = br.readLine();

            if(!str.equals("0")){
                for(int i =0;i< str.length() ; i++){
                    keys[str.charAt(i)-'a'] = true;
                }
            }

            bfs();

            System.out.println(res);

        }

    }
}