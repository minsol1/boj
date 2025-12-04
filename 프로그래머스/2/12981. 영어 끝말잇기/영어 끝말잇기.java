import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] res = new int[2];

        int people = 1;
        char c = words[0].charAt(0);
        HashSet<String> hs = new HashSet<>();
        
        for(String str : words){
            char s = str.charAt(0);
            
            if(s != c || hs.contains(str)){
                res[0] = people%n;
                if(res[0]== 0) res[0] = n;
                
                res[1] = people/n;
                if(people % n >= res[0]) res[1]++;
                break;
             }
            people++;
            c = str.charAt(str.length()-1);
            hs.add(str);
        }
        return res;
    }
}