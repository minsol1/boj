class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long l = 1; 
        long r = 1000000000*(long)n;
        
        while(l<=r){
            long m = l + (r-l)/2;
            long sum = 0;
            
            for(int i =0; i < times.length; i++){
                sum += m / times[i];
            }
            
            if(sum >=n){
                r = m-1;
                answer = m;
            }
            else{
                l = m+1;
            }
        }
        return answer;
    }
}