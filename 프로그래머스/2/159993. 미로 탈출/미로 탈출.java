import java.util.*;

class Solution {
    public static char[][] arr;
    public static int[][][] visited;
    public static int N,M;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y,0});
        visited[x][y][0]++;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d = 0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx <0 || nx >=N || ny <0 || ny >=M
                   || visited[nx][ny][now[2]]!=-1 ||arr[nx][ny]== 'X') continue;
                
                int l = now[2];
                if(arr[nx][ny] == 'L') l =1;
                visited[nx][ny][l] = visited[now[0]][now[1]][now[2]] +1;
                q.add(new int[]{nx,ny,l});
            }
        }
        
    }
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        arr = new char[N][M];
        visited = new int[N][M][2];
        int goalX =0;
        int goalY =0;
        int startX = 0;
        int startY = 0;
        
        for(int i =0 ;i< N ;i++){
            for(int j = 0; j< M; j++){
                Arrays.fill(visited[i][j],-1);
            }
        }
        
        for(int i =0; i<N;i++){
            for(int j =0; j<M;j++){
                arr[i][j]= maps[i].charAt(j);
                if(arr[i][j] == 'E'){
                    goalX = i;
                    goalY = j;
                }
                if(arr[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
            }
        }
        
        bfs(startX,startY);
        
        return visited[goalX][goalY][1];
        
    }
}