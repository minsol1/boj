class Solution {
    
    public static int N, res;
    public static boolean[] visited;
    public static int[][] arr;
    
    public static void dfs(int k, int cnt){
        if(cnt > res ) res = cnt;
        
        for(int i =0; i< N; i++){
            if(!visited[i] && k >= arr[i][0]){
                visited[i] = true;
                dfs(k-arr[i][1], cnt+1);
                visited[i] = false;
            }
        }
        
    }
    public int solution(int k, int[][] dungeons) {
        res = 0;
        N = dungeons.length;
        visited = new boolean[N];
        arr = dungeons;
        
        dfs(k,0);
        
        return res;
    }
}