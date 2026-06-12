import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        
        for(int i =0; i< clothes.length ; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            
            if(!hm.containsKey(type)){
                hm.put(type, new HashSet<String>());
                hs.add(type);
            }
            hm.get(type).add(name);
        }
        
        for(String type : hs){
            answer *= (hm.get(type).size()+1);
        }
        answer --;
        
        return answer;
    }
}