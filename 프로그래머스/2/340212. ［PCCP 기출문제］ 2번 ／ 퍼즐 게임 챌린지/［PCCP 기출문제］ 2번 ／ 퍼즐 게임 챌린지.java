class Solution {
    public static int[] diff;
    public static int[] time;
    public static long lim;
    public static int N;
    
    public static boolean get_time(int level){
        long total = 0;
        
        for(int i =0; i<N; i++){
            int d = diff[i]; // 난이도 
            int cur = time[i];// 현재 퍼즐 시간
            int prev = 0; // 이전 퍼즐 시간 
            if(i >0){
                prev = time[i-1];
            }
            
            if(d <= level){
                total+= cur;
            }
            else{
                total += ((d-level)*(cur+prev) + cur);
            }
            
            if(total >lim) return false;
        }
        
        return true;
        
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        diff = diffs;
        time = times;
        lim = limit;
        N = diffs.length;
        
        int l = 1;
        int r = 100000;
        
        while(l <= r){
            int m = l + (r - l)/2;
            
            if(get_time(m)){
                answer = m;
                r = m -1;
            }
            else{
                l = m+1;
            }
        }
        
        return answer;
    }
}