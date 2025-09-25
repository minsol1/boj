class Solution {

    public int solution(int sticker[]) {
        int res = 0;
        int N = sticker.length;
        int[][] dp = new int[2][N+1];
        dp[0][1] = sticker[0];
        
        for(int i =2; i<N+1; i++){
            
            dp[0][i] = Math.max(dp[0][i-1] , dp[0][i-2]+ sticker[i-1]);
            dp[1][i] = Math.max(dp[1][i-1] , dp[1][i-2]+ sticker[i-1]);
            
            if(i == N){
                dp[0][i] = dp[0][i-1] ;
            }
        }
        res = Math.max(dp[0][N] , dp[1][N]);
        
        return res;
    }
}