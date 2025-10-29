import java.util.*;
class Solution {
    public static char[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static ArrayList<Integer> res;
    public static int N,M;
    
    public static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int c = arr[x][y]-'0';
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d = 0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || nx>=N || ny <0 || ny >=M 
                   || visited[nx][ny] || arr[nx][ny]== 'X') continue;
                
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
                c += arr[nx][ny]-'0';
            }
        }
        res.add(c);
        
    }
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        arr = new char[N][M];
        visited = new boolean[N][M];
        res = new ArrayList<>();
        
        for(int i =0; i<N;i++){
            for(int j =0; j<M;j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i =0; i<N;i++){
            for(int j =0; j<M; j++){
                if(arr[i][j]!='X' && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        
        int[] answer = new int[res.size()];
        Collections.sort(res);
        
        for(int i = 0; i< res.size(); i++){
            answer[i] = res.get(i);
        }
        
        if(res.size()==0) answer =new int[] {-1};
        return answer;
    }
}