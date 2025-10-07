import java.util.*;

class Node{
    int x;
    int y;
    int d;
    
    public Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    
    public static int N;
    public static int[][] arr;
    public static int[][][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    
    public static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        q.add(new Node(0,0,1));
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int d = 0; d<4 ;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if(nx <0 || nx >=N || ny <0 || ny >=N || arr[nx][ny]==1) continue;
                
                int cost = visited[now.x][now.y][now.d] + 100;
                
                if(d%2 != now.d%2 ){
                    cost+=500;
                }
                
                if(visited[nx][ny][d] > cost){
                    visited[nx][ny][d] = cost;
                    q.add(new Node(nx,ny,d));
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        arr = board;
        N = board.length;
        visited= new int[N][N][4];
        
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N;j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs();
        int res = Integer.MAX_VALUE;
        for(int i =0; i<4; i++){
            res = Math.min(res, visited[N-1][N-1][i]);
        }
        return res;  
        
    }
}