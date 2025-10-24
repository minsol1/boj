import java.util.*;

class Solution {
    public static int N,M,res;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int[][] visited;
    public static char[][] arr;
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y]++;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d=0;d<4;d++){
                int nx = now[0];
                int ny = now[1];
                int a = nx;
                int b = ny;
                
                while(nx<N && nx >=0 &&ny<M && ny >=0 && arr[nx][ny]!='D'){
                    a = nx;
                    b = ny;
                    nx += dx[d];
                    ny += dy[d];
                }
                if(visited[a][b]!= -1) continue;
                visited[a][b] = visited[now[0]][now[1]]+1;
                q.add(new int[]{a,b});
                if(arr[a][b] == 'G'){
                    res = visited[a][b];
                    return;
                }
                
            }
        }
        res = -1;
        
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new int[N][M];
        arr = new char[N][M];
        int x=0;
        int y =0;
        
        for(int i =0; i< N; i++){
            Arrays.fill(visited[i],-1);
        }
        for(int i =0; i< N; i++){
            for(int j =0; j< M; j++){
                char c = board[i].charAt(j);
                arr[i][j]= c;
                if(c == 'R'){
                    x = i;
                    y = j;
                }
            }
        }
        
        bfs(x,y);
        
        return res;
    }
}