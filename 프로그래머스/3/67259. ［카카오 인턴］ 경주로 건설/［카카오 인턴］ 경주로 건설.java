import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int c;
    int d;
    
    public Node (int x, int y, int c , int d){
        this.x = x;
        this.y = y;
        this.c = c;
        this.d = d;
    }
    
    public int compareTo(Node o){
        return this.c - o.c;
    }
}

class Solution {
    
    public static int[][] arr;
    public static int N;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int[][][] visited;
    
    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,0,0});
        q.add(new int[]{0,0,0,1});
        q.add(new int[]{0,0,0,2});
        q.add(new int[]{0,0,0,3});
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        visited[0][0][2] = 0;
        visited[0][0][3] = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d = 0; d<4; d++){
                int nx = now[0]+ dx[d];
                int ny = now[1]+ dy[d];
                int nc = now[2];
                
                if(now[3] %2 == d %2){
                    nc +=100;
                }
                else{
                    nc +=600;
                }
                
                if(nx < 0 || nx >=N || ny < 0 || ny >=N || visited[nx][ny][d] < nc || arr[nx][ny] ==1)
                    continue;
                
                q.add(new int[] {nx,ny, nc, d});
                visited[nx][ny][d] = nc;
                
            }
        }
        
    }
    
    public int solution(int[][] board) {
        N = board.length;
        arr = board;
        visited = new int[N][N][4];
        for(int i =0; i<N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs();
        // for(int i =0; i<N; i++){
        //     for(int j =0; j< N ; j++){
        //         System.out.print(visited[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        Arrays.sort(visited[N-1][N-1]);
        int answer = visited[N-1][N-1][0];
        return answer;
    }
}