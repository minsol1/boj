import java.util.*;
import java.io.*;
class Solution {
    public static ArrayList<Integer> res;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static boolean[][] visited;
    public static int N, M;
    public static int[][] arr;
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        int c = arr[x][y];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d = 0; d<4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || nx >=N || ny < 0 || ny >=M || visited[nx][ny] || arr[nx][ny]==0) continue;
                
                c += arr[nx][ny]; 
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                
            }
        }
        return c;
    }
    
    
    public int[] solution(String[] maps) {
        res = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        arr =new int[N][M];
        
        for(int i =0; i< N; i++){
            for(int j =0; j< M; j++){
                
                if(maps[i].charAt(j) == 'X') arr[i][j] = 0;
                else    arr[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        
        for(int i =0 ; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j] && arr[i][j] != 0){
                    res.add(bfs(i,j));
                }
            }
        }
        
        if(res.size()== 0) {
            int[] answer = {-1};
            return answer;
        }
        else{
            int[] answer = new int[res.size()];
            for(int i = 0; i< res.size(); i++){
                answer[i] = res.get(i);
            }        
            Arrays.sort(answer);
        
            return answer;
        }
            
            
        
    }
}