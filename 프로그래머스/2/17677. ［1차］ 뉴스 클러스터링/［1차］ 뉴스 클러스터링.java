import java.util.*;

class Solution {
    public static boolean check(String str){
        for(int i =0; i<str.length(); i++){
            char c  = str.charAt(i);
            
            if(c < 'A' || c > 'Z') return false;
        }
        return true;
    }
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        HashSet<String> hsUnion = new HashSet<>();
        HashSet<String> hsAnd = new HashSet<>();
        int union = 0;
        int and = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i =0 ; i < str1.length()-1; i++){
            String sub = str1.substring(i, i+2);
            if(!check(sub)) continue;
            
            hm1.put(sub, (int)hm1.getOrDefault(sub,0)+1);
            hsUnion.add(sub);
        }
        for(int i =0 ; i < str2.length()-1; i++){
            String sub = str2.substring(i, i+2);
            if(!check(sub)) continue;
            
            hm2.put(sub, (int)hm2.getOrDefault(sub,0)+1);
            hsUnion.add(sub);
            
            if(hm1.containsKey(sub)){
                hsAnd.add(sub);
            }
        }
        
        for(String str : hsUnion){
            int n1 = hm1.getOrDefault(str, Integer.MIN_VALUE);
            int n2 = hm2.getOrDefault(str, Integer.MIN_VALUE);
            union += Math.max(n1,n2);
        }
       for(String str : hsAnd){
            and += Math.min(hm1.get(str), hm2.get(str));
        }
        
        if(and == 0 && union == 0) return 65536;
        float f  = (float)and/(float)union;
        answer = (int)(f*65536);
        return answer;
    }
}