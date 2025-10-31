import java.util.*;
class Solution {
    public static int X,Y,N;
    public static int[] visited;
    
    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        visited[X]++;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            int nx = now +N ;
            
            if(nx <= Y && visited[nx]==-1){
                visited[nx] = visited[now]+1;
                q.add(nx);
            }
            
            nx = now *2 ;
            if(nx <= Y && visited[nx]==-1){
                visited[nx] = visited[now]+1;
                q.add(nx);
                
            }
            
            nx = now *3 ;
            if(nx <= Y && visited[nx]==-1){
                visited[nx] = visited[now]+1;
                q.add(nx);
            }
        }
    }
    public int solution(int x, int y, int n) {
        visited = new int[y+1];
        X = x;
        Y = y;
        N = n; 
        
        Arrays.fill(visited,-1);
        bfs();
        
        return visited[y];
    }
}