class Solution {
    
    public static int res, N;
    public static int[] arr;
    
    public static boolean isPrime(int num ){
        
        for(int i = 2; i <num; i++){
            if(num%i == 0) return false;
        }
        return true;
        
    }
    
    public static void dfs(int idx, int sum, int cnt){
        if(cnt == 3){
            if(isPrime(sum)){
                res++;
            }
            return;
        }
        if(idx == N) return;
        
        dfs(idx+1, sum, cnt);
        dfs(idx+1, sum+arr[idx] , cnt+1);
        
    }
    public int solution(int[] nums) {
        res =0;
        arr = nums;
        N = nums.length;
        
        dfs(0, 0,0);
        
        return res;
    }
}