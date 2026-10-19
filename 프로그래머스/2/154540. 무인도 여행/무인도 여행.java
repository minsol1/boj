import java.util.*;
import java.io.*;

class Solution {
    
    public static int N,M;
    public static boolean[][] visited;
    public static int[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    
    public static int bfs(int x, int y){
        int sum = 0;
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        sum += arr[x][y];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d =0; d<4 ;d ++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || nx >=N || ny < 0 || ny >=M || visited[nx][ny] || arr[nx][ny] ==-1) continue;
                
                sum += arr[nx][ny];
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                // System.out.println(nx+" "+ny +" "+sum);
                
            }
            
        }
        // System.out.println(x+" "+y +" "+sum+"------");
        return sum;
        
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i =0; i< N ; i++){
            String str = maps[i];
            for(int j = 0; j< M; j++){
                char c = str.charAt(j);
                if(c == 'X'){
                    arr[i][j] = -1;
                }
                else {
                    arr[i][j] = c -'0';
                }
            }
        }
        
        for(int i =0; i< N; i++){
            for(int j =0; j < M; j ++){
                if(arr[i][j] != -1 && !visited[i][j]){
                    answer.add(bfs(i,j));
                }
            }
        }
        
        Collections.sort(answer);
        int len = answer.size();
        if(len != 0){
            int[] res = new int [len];
            for(int i =0; i< len; i++){
                res[i] = answer.get(i);
            }
            return res;
        }
        else{
            int[] res = {-1};
            return res;
        }
        
    }
}