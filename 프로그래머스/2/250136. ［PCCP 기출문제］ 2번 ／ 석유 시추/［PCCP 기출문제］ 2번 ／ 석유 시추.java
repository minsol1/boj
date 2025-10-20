import java.util.*;
class Solution {
    public static ArrayList<Integer> oil; // 석유 크기 
    public static int[][] arr;
    public static int[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int N,M,idx;
    
    public static void bfs(int x, int y){ // 인접한 석유 
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = idx;
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[]now = q.poll();
            
            for(int d = 0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx < 0 || nx >=N || ny<0 || ny>=M || visited[nx][ny]!=0 || arr[nx][ny]!= 1) continue;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = idx;
                cnt++;
            }
        }
        oil.add(cnt);
        
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        int res = 0;
        oil = new ArrayList<>();
        arr = land;
        visited = new int[N][M];
        idx = 1;
        
        for(int i =0; i< N; i++){
            for(int j = 0; j< M;j++){
                if(arr[i][j] == 1 && visited[i][j]== 0){
                    bfs(i,j);
                    idx++;
                }
            }
        }
        
        
        for(int i =0; i< M ; i++){
            int sum =0;
            boolean[] isVisited = new boolean[idx+1];
            for(int j = 0; j < N ; j++){
                int num =visited[j][i];
                if(num!= 0 && !isVisited[num-1]){
                    sum += oil.get(num-1);
                    isVisited[num-1] = true;
                }
            }
            res = res > sum ? res : sum;
        }
        
        return res;
    }
}