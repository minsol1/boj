import java.util.*;
class Solution {
    public static int N;
    public static boolean[] visited;
    public static int[][] arr;
    
    public static void bfs(int s){
        Queue<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i<N;i++){
                if(arr[now][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[N];
        arr = computers;
        for(int i =0;i<N;i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
}