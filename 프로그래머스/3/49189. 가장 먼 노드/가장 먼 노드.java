import java.io.*;
import java.util.*;

class Solution {
    
    public static int N, max_dep, cnt;
    public static int[] visited;
    public static ArrayList<Integer>[] arr;
    
    public static void bfs(int start){
        visited[start] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i< arr[now].size(); i++){
                int nx = arr[now].get(i);
                if(visited[nx] != -1) continue;
                
                visited[nx] = visited[now]+1;
                q.add(nx);
                if(visited[nx] == max_dep){
                    cnt++;
                } 
                else if(visited[nx] > max_dep ){
                    max_dep = visited[nx];
                    cnt = 1;
                }
            }
        }
        
    }
    
    public int solution(int n, int[][] edge) {
        N = n;
        max_dep = 0;
        cnt = 0;
        visited = new int[N+1];
        arr = new ArrayList[N+1];
        
        Arrays.fill(visited, -1);
        
        for(int i =0; i< N+1; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i =0; i< edge.length; i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        
        bfs(1);
        
        return cnt;
    }
}