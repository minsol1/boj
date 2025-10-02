class Solution {
    public static int[] arr;
    public static int N;
    public static int K;
    public static boolean isPossible(int m){
        int cnt =0;
        
        for(int i =0; i<N ; i++){
            if(arr[i]- m < 0){
                cnt++;
            }
            else cnt =0;
            
            if(cnt == K) return false;
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        arr = stones;
        N = stones.length;
        K = k;
        
        int l = 1; 
        int r = 200000000;
        
        while(l!=r){
            int m = r - (r-l)/2;
            
            if(isPossible(m)){
                l = m;
            }
            else{
                r = m-1;
            }
        }
        
        return l;
        
    }
}