import java.util.*;

class Solution {
    
    public static String b, t;
    public static String[] word;
    public static HashSet<String> hs;
    public static HashMap<String,Integer> visited;
    
    public static int dif(String s, String c){
        
        int cnt = 0; 
        for(int i =0; i< s.length(); i++){
            if(s.charAt(i) != c.charAt(i)){
                cnt++;
            }
            if(cnt > 1) return cnt;
        }
        // System.out.println(s+" "+c+" "+ cnt );
        
        return cnt;
        
    }
    
    public static void bfs(String s){
        visited.put(s,0);
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        
        while(!q.isEmpty()){
            
            String now = q.poll();
            
            for(String nx : word){
                if(visited.containsKey(nx) || 1 < dif(now, nx)){
                    continue;
                }
                
                visited.put(nx, visited.get(now)+1);
                q.add(nx);
            }
        }
        
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        hs = new HashSet<>();
        visited = new HashMap<>();
        b = begin;
        t = target;
        word = words;
        
        for(String str : words){
            hs.add(str);
        }
        
        bfs(begin);
        
        if(visited.containsKey(t)){
            answer = visited.get(t);
        }
        
        
        return answer;
    }
}