import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        HashSet<String> hs2 = new HashSet<>();
        
        for(String str : phone_book){
            if(hs2.contains(str)){
                answer = false;
                return answer;
            }
            for(int i =0; i< str.length(); i++){
                String sub =str.substring(0,i);
                if(hs.contains(sub)){
                    answer = false;
                    return answer;
                }
                hs2.add(sub);
            }
            hs.add(str);
        }
        return answer;
    }
}