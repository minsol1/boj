class Solution {
    public int[] arr;
    public int tar;
    public int res;
    
    public void dfs(int cnt, int total){
        if(cnt == arr.length){
            if(total == tar){
                res ++;
            }
            return;
        }
        
        dfs(cnt+1,total+ arr[cnt]);
        dfs(cnt+1,total-arr[cnt]);
    }
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        tar = target;
        res =0;
        dfs(0,0);
        
        return res;
    }
}