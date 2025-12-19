import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i =0; i< clothes.length; i++){
            String type = clothes[i][1];
            
            if(hm.containsKey(type)){
                hm.put(type, hm.get(type)+1);
            }
            else{
                hm.put(type,1);
            }
        }
        
        for(int n : hm.values()){
            answer*=(n+1);
        }
        answer--;
        return answer;
    }
}