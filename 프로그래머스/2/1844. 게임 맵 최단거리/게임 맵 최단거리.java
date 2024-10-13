import java.util.*;
class Solution {
    public int[] dx = {0,1,0,-1};
    public int[] dy = {1,0,-1,0};
    
    public int bfs(int[][] map){
        int N = map.length;
        int M = map[0].length;
        int[][] visited= new int[N][M];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        visited[0][0]++;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==N-1 && now[1]== M-1){
                return visited[now[0]][now[1]];
            }
            for(int d = 0; d<4;d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if(nx>=0 && nx<N && ny >=0 && ny<M&& map[nx][ny]==1
                   && visited[nx][ny]==0){
                   visited[nx][ny] = visited[now[0]][now[1]]+1;
                    q.add(new int[]{nx,ny});
                    
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
}