import java.util.*;

class Solution {
    public static int[] pick;
    public static int[][] hp = new int[][] {{1,1,1},{5,1,1},{25,5,1}};
    public static int[][] arr;
    public static int res, N;
    
    public static void dfs(int idx, int sum){
        if(idx == N){
            res = res < sum ? res : sum;
            return;
        }
        if(pick[0]==0 && pick[1]==0 && pick[2]==0){
            res = res < sum ? res : sum;
            return;
        }
        
        for(int i =0; i < 3; i++){
            if(pick[i] >0){
                
                pick[i]--;
                dfs(idx+1, sum +arr[idx][i]);
                pick[i]++;
            }
        }
        
    }
    public int solution(int[] picks, String[] minerals) {
        res = Integer.MAX_VALUE;
        pick = picks;
        N = minerals.length/5+1;
        if(minerals.length %5 ==0)N--;
        arr = new int[N][3];
        
        for(int i =0; i<minerals.length ; i++ ){
            int idx = 0;
            if(minerals[i].equals("diamond")) idx = 0;
            if(minerals[i].equals("iron")) idx = 1;
            if(minerals[i].equals("stone")) idx = 2;
            
            arr[i/5][0] += hp[0][idx];
            arr[i/5][1] += hp[1][idx];
            arr[i/5][2] += hp[2][idx];
        }
        
        dfs(0,0);
        
        return res;
    }
}