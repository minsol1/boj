import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 
        
        for(int i =0; i< info.length; i++){
            int A = info[i][0];
            int B = info[i][1];
            int[] newdp =new int[n];
            Arrays.fill(newdp, Integer.MAX_VALUE);
            
            for(int j = 0; j<n;j++){
                
                if(dp[j] == Integer.MAX_VALUE) continue;
                
                if(j + A < n ){
                    newdp[j+A] = Math.min(newdp[j+A], dp[j]);
                }
                
                if(dp[j] + B < m){
                    newdp[j] = Math.min(dp[j] + B, newdp[j]);
                }
            }
            
            dp = newdp;
        }
        
        for(int i = 0; i< n; i++){
            if(dp[i] != Integer.MAX_VALUE) return i;
        }
        return -1;
        
        
    }
}