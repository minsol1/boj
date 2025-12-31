import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int t : topping){
            hm.put(t, hm.getOrDefault(t,0)+1);
        }
        
        for(int t : topping){
            hs.add(t);
            hm.put(t, hm.getOrDefault(t,0)-1);
            if(hm.get(t)==0 ) hm.remove(t);
            
            if(hs.size()== hm.size()) answer++;
        }
        return answer;
    }
}