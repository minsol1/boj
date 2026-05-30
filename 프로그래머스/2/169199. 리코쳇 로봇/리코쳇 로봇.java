import java.util.*;
import java.io.*;

class Solution {
    
    public static int N,M, res;
    public static int[][] visited;
    public static char[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    
    public static void bfs(int x, int y){
        Queue<int[] > q = new ArrayDeque<>();
        visited[x][y] = 0;
        q.add(new int[] {x,y});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            // System.out.println(now[0]+" "+ now[1]);
            
            for(int d= 0; d<4; d++){
                int n =0;
                int nx = now[0] + dx[d]*(n+1); 
                int ny = now[1] + dy[d]*(n+1);
                
                while(nx >= 0 && nx < N && ny >=0 && ny <M && arr[nx][ny]!= 'D'){
                    n++;
                    nx = now[0] + dx[d]*(n+1); 
                    ny = now[1] + dy[d]*(n+1);
                }
                nx = now[0] + dx[d]*n; 
                ny = now[1] + dy[d]*n;
                
                if(visited[nx][ny] != -1) continue;
                
                
                q.add(new int[] {nx, ny});
                visited[nx][ny] = visited[now[0]][now[1]]+1;
                if(arr[nx][ny] == 'G'){
                    res = visited[nx][ny];
                    return;
                }
                
            }
        }
    }
    
    public int solution(String[] board) {
        res = -1;
        N = board.length;
        M = board[0].length();
        visited = new int[N][M];
        arr= new char[N][M];
            
        //파싱
        int x =0;
        int y =0;
        
        for(int i = 0; i< N; i++){
            Arrays.fill(visited[i],-1);
        }
        
        for(int i =0; i < N ; i++){
            for(int j =0; j< M; j++){
                arr[i][j] = board[i].charAt(j);
                
                if(arr[i][j]== 'R'){// 시작점
                    x = i;
                    y = j;
                    // System.out.println(x+" "+ y);
                }
            }
        }

        bfs(x, y);
        
        return res;
    }
}