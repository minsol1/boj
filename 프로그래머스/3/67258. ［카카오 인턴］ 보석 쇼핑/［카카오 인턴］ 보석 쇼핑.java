import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        int N = gems.length;
        int cnt = 0; 
        int min = N;
        HashSet<String> hs = new HashSet<>();
        HashMap<String,Integer> hm = new HashMap<>();
        int[] res = new int[]{1,N};
        
        for(int i =0; i< N ;i++){
            hs.add(gems[i]);
        }
        cnt = hs.size();
        
        int l = 0; 
        int r = 0; 
        
        while(l <= r){
            if(hm.size() == cnt){
                hm.put(gems[l], hm.getOrDefault(gems[l],1)-1);
                if(hm.get(gems[l])== 0 ) hm.remove(gems[l]);
                l++;
                
                if(r -l +1 < min){
                    min = r -l +1;
                    res = new int[]{l, r};
                }
                
            }
            else{
                if(r>=N) break;
                hm.put(gems[r], hm.getOrDefault(gems[r],0)+1);
                r++;
            }
            
        }
        
        return res;
    }
}