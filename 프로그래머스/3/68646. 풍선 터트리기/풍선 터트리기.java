import java.util.*;
class Solution {
    public int solution(int[] a) {
        int res = 0;
        int[] rmin = new int[a.length];
        int min =  Integer.MAX_VALUE;
        
        for(int i =a.length-1; i>=0; i-- ){
            rmin[i] = min;
            if(min > a[i]) min = a[i];
        }
        
        int lmin = Integer.MAX_VALUE;
        for(int i =0; i< a.length; i++){
            if(lmin>=a[i] || a[i] <= rmin[i]){
                res ++;
            }
            if(lmin > a[i]) lmin = a[i];
        }
        
        return res;
    }
}