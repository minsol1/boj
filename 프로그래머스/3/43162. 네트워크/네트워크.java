import java.util.*;
class Solution {
    public static boolean[] visited;
    public static int N ; 
    public static ArrayList<Integer>[] arr;
    public static int res; 
    
    
    public static void bfs(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i =0; i< arr[now].size(); i++ ){
                int nx = arr[now].get(i);
                
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
        
        
        
    }
    
    
    public int solution(int n, int[][] computers) {
        res = 0;
        visited = new boolean[n];
        N = n;
        arr = new ArrayList[n];
        for(int i = 0 ; i <N; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i =0; i< computers.length ; i++){
            
            for(int j =0; j< computers[i].length; j++){
                if(computers[i][j] == 1){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        
        for(int i =0; i< N ; i++ ){
            if(!visited[i]){
                bfs(i);
                res ++;
                
            }
        }
        
        return res;
    }
}