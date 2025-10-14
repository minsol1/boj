import java.util.*;
class Solution {
    public static int[] time;
    public static int[] diff;
    public static long lim;
    public static int N;
    
    public static boolean isPossible(int lev){
        int time_prev = 0;
        long sum = 0;
        
        for(int i = 0; i<N;i++){
            if(lev >= diff[i]){
                sum+= time[i];
            }
            else{
                sum= sum + (diff[i]-lev)*(time[i]+time_prev) + time[i];
            }
            time_prev = time[i];
            if(sum > lim) return false;
        }
        System.out.println(lev+" "+ sum);
        return true;
        
    }
    public int solution(int[] diffs, int[] times, long limit) {
        diff = diffs;
        time = times;
        lim = limit;
        N = times.length;
        int r = 0;
        
        for(int i =0; i < N; i++){
            r = Math.max(r, diffs[i]);
        }
        
        int l = 1;
        int res = r;
        
        while(l<r){
            int m = l + (r-l)/2;
            
            if(isPossible(m)){
                r = m;
                res = m;
            }
            else{
                l = m+1;
            }
        }
        
        return res;
    }
}