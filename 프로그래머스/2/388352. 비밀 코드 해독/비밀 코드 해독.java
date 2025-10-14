class Solution {
    
    public static int N,M;
    public static boolean[] num;
    public static int res;
    public static int[][] com;
    public static int[] answer;
    
    public static void dfs(int idx, int cnt){
        if(cnt == 5){
            for(int i =0; i< M; i++){
                int c =0;
                for(int j = 0; j<5;j++){
                    if(num[com[i][j]]) c++;
                }
                if(answer[i]!= c) return;
            }
            res++;
            return;
        }
        if(idx >= N) return;
        
        for(int i = idx+1; i <= N;i++){
            num[i] = true;
            dfs(i,cnt+1);
            num[i] = false;
        }
        
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        M = q.length;
        com = q;
        answer = ans;
        num = new boolean[N+1];
        res = 0;
        
        dfs(0,0);
        return res;
    }
}