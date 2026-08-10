import java.util.*;
import java.io.*;

class Solution {
    
    public static int N;
    public static ArrayList<Integer>[] win;
    public static ArrayList<Integer>[] lose;
    
    public static int bfs(int start, ArrayList<Integer>[] arr){
        Queue<int[]> q = new ArrayDeque<>();
        int[] visited = new int[N];
        Arrays.fill(visited, -1);
        q.add(new int[] {start, 0});
        
        int dep = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int nx : arr[now[0]]){
                if(visited[nx] != -1) continue;
                dep++;
                visited[nx] = now[1]+1;
                q.add(new int[] {nx, visited[nx]});
            }
        }
        
        return dep;
        
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        win = new ArrayList[N];
        lose = new ArrayList[N];
        
        for(int i =0; i< N; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for(int i = 0; i< results.length ; i++){
            int a = results[i][0]-1;
            int b = results[i][1]-1;
            
            win[a].add(b);
            lose[b].add(a);
        }
        
        for(int i = 0; i < N ; i++){
            // System.out.println(i+ " "+bfs(i,win) + " "+ bfs(i,lose));
            if (bfs(i,win) + bfs(i,lose) == N-1){
                answer++;
            }
        }
        
        return answer;
    }
}