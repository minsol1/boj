import java.util.*;

class Solution {
    public static String SKILL;
    
    public static boolean skill(String tree){
        boolean[] possible = new boolean[26];
        char[] s = new char[SKILL.length()];
        int idx = 0;
        
        for(int i = 0; i< SKILL.length(); i++){
            char c = SKILL.charAt(i);
            s[i] = c;
            
            if(i!=0 ){
                possible[c -'A'] = true;
            }
        }
        
        for(int i =0; i< tree.length(); i++ ){
            char now = tree.charAt(i);
            
            if(idx < SKILL.length() && s[idx] == now){
                possible[now-'A'] = false;
                idx++;
            }
            
            if(possible[now-'A']) return false;
        }
        
        return true;
        
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        SKILL = skill;
        
        for(String str : skill_trees){
            if (skill(str) ) answer++;
        }
        
        return answer;
    }
}