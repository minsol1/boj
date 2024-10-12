import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        for(String name : completion){
            if(hs.containsKey(name)){
                hs.replace(name, hs.get(name)+1);
            }
            else{
                hs.put(name, 1);
            }
        }
        
        for(String name : participant){
            if(hs.containsKey(name)){
                if(hs.get(name)==0){
                    answer = name;
                    break;                    
                }
                else{
                    hs.replace(name, hs.get(name)-1);
                }

            }
            else{
                answer = name;
                break;   
            }
        }
        System.out.println(answer);
        return answer;
    }
}