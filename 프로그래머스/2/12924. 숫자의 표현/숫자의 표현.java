class Solution {
    public int solution(int n) {
        int res = 0;
        int l = 0; 
        int r = 0;
        int sum = 0;
        
        while(l<=r){
            if(sum < n){
                r++;
                sum+=r;
            }
            else if(sum > n){
                sum-=l;
                l++;
            }
            
            if(sum == n){
                res++;
                r++;
                sum+=r;
            }
            if(r>n) break;
        }
        return res;
    }
}