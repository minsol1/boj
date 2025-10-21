class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int n = sequence.length;
            
        int l = 0; 
        int r = 0;
        int sum = 0;
        
        while(true){
            if(sum > k){
                sum-=sequence[l];
                l++;
            }
            else if(r == n) break;
            else if(sum <= k){
                sum+=sequence[r];
                r++;
            }
            if(sum == k){
                if(min > r - l){
                    min = r-l;
                    answer= new int[]{l,r-1};
                }
            }
            
        }
        return answer;
    }
}