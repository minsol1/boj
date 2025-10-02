import java.util.*;

class Solution {
    
    public static int N;
    public static ArrayList[] arr;
    public static int[] visited;
    public static int res, max;
    
    public static void bfs(){
        visited[1] = 0; 
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i =0; i < arr[now].size(); i++){
                int nx = (int)arr[now].get(i);
                
                if(visited[nx]==-1){
                    
                    visited[nx] = visited[now]+1;
                    q.add(nx);
                    
                    if(visited[nx] > max){
                        res = 1; 
                        max = visited[nx];
                    }
                    else if (visited[nx] == max){
                        res++;
                        System.out.println(nx+" "+max);
                    }
                }
            }
        }
         
    }
    
    public int solution(int n, int[][] edge) {
        res = 0;
        max = 0;
        N = n;
        visited = new int[N+1];
        arr = new ArrayList[N+1];
        
        for(int i =0; i<N+1; i++){
            arr[i] = new ArrayList<Integer>();
            visited[i] = -1;
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        bfs();
        
        return res;
    }
}