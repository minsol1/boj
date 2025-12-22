class Solution {
    public static int res, N ;
    public static boolean[] visited;
    public static int[][] dun;
    
    public static void dfs(int p, int cnt){
        res = res > cnt ? res: cnt;
        
        for(int i = 0; i<N;i++){
            if(!visited[i] && p >= dun[i][0]){
                visited[i] = true;
                dfs(p-dun[i][1],cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        dun = dungeons;
        res = 0;
        
        dfs(k,0);
        
        return res;
    }
}