import java.util.*;

class Solution {
    
    public static int N,M,res;
    public static char[][] arr;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    
    public static void fork(char c){
        Queue<int []> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+2][M+2];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        ArrayList<int[]> a = new ArrayList<>();
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int d =0; d<4;d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(nx < 0 || nx >=N+2 || ny <0 || ny >=M+2 || visited[nx][ny] ) continue;
                
                visited[nx][ny] = true;
                if(arr[nx][ny]==' '){
                    q.add(new int[]{nx, ny});
                }
                if(arr[nx][ny]== c ){
                    res --;
                    a.add(new int[]{nx,ny});
                }
            }
            
        }
        
        for(int[] tem : a){
            arr[tem[0]][tem[1]] = ' ';
        }
        
    }
    
    public static void crane(char c){
        for(int i =0; i<N+2; i++){
            for(int j =0; j<M+2 ; j++){
                if(arr[i][j] == c){
                    arr[i][j] = ' ';
                    res--;
                }
            }
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        res = N*M;
        arr = new char[N+2][M+2];
        int req = requests.length;
        
        for(int i =0; i<N; i++){
            String str = storage[i];
            
            for(int j =0; j<M;j++){
                
                arr[i+1][j+1]= str.charAt(j);
            }
        }
        for(int i =0; i<N+2;i++){
            arr[i][0] = ' ';
            arr[i][M+1] = ' ';
        }
        for(int i =0; i<M+2;i++){
            arr[0][i] = ' ';
            arr[N+1][i] = ' ';
        }
        
        for(int i =0; i<req ; i++){
            String str = requests[i];
            if(str.length() == 2){
                crane(str.charAt(0));
            }
            else{
                fork(str.charAt(0));
            }
        }
        
        return res;
    }
}