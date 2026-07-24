import java.util.*;
class Solution {
    
    public static char[][] arr;
    public static int[] dx = {0,1,0,-1};        
    public static int[] dy = {1,0,-1,0};
    public static int N = 5;
    
    public static boolean bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        visited[x][y] = true;
        q.add(new int[]{x,y,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[2] == 2) continue;
            
            for(int d = 0; d<4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx < 0 || nx >=N || ny <0 || ny >=N || visited[nx][ny] || arr[nx][ny] == 'X')
                    continue;
                if(arr[nx][ny] == 'P') {
                    return false;
                }
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,now[2]+1});
                
            }
        }
        return true;
        
    }
    
     public int[] solution(String[][] places) {
        int[] answer = new int[N];
        arr = new char [N][N];
         
        for(int i = 0; i< N; i++){
            
            for(int j = 0 ; j <N; j++){
                
                for(int k =0; k< N; k++){
                    arr[j][k] = places[i][j].charAt(k);
                }
            }
            answer[i] = 1;
            
            for(int j = 0 ; j <N; j++){
                
                for(int k =0; k< N; k++){
                    
                    if(arr[j][k] == 'P'){
                        if(!bfs(j,k)){
                            answer[i] = 0;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}