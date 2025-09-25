import java.util.*;
class Solution {
    public static int N,M;
    public static String[] user;
    public static String[] ban;
    public static HashSet<HashSet<String>> res;
    
    public static void dfs(int idx, HashSet<String> hs){
        if(idx == M){
            res.add(hs);
            return;
        }
        
        for(int i =0; i< N ; i++){
            if(hs.contains(user[i])) continue;
            
            if(check(user[i], ban[idx])){
                hs.add(user[i]);
                dfs(idx + 1, new HashSet(hs));
                hs.remove(user[i]);
            }
        }
        
    }
    
    public static boolean check(String user, String banned){
        if(user.length() != banned.length()) return false;
        
        for(int i =0; i< user.length() ; i++){
            if(banned.charAt(i) !='*' &&  banned.charAt(i) !=user.charAt(i))
                return false;
        }
        
        return true;
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        res = new HashSet<>();
        user = user_id;
        ban = banned_id;
        HashSet<String> hs = new HashSet<>();
        
        dfs(0,hs);
        
        return res.size();
    }
}