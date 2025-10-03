import java.util.*;

class Solution {
    public static int N ;
    public static String[][] arr;
    public static boolean[] visited;
    public static String[] res;
    
    
    public static void dfs(String s, ArrayList<String> path){
        if(res != null) return;
        
        if(path.size() == N+1){
            res = path.toArray(new String[path.size()]);
            return;
        }
        
        for(int i =0; i<N;i++){
            if(visited[i] || !arr[i][0].equals(s)) continue;
            
            visited[i] = true;
            path.add(arr[i][1]);
            
            dfs(arr[i][1], path );
            visited[i] = false;
            path.remove(path.size()-1);
        }
 
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        arr = tickets;
        visited = new boolean[N];
        
        Arrays.sort(arr, (o1,o2) ->o1[1].compareTo(o2[1]));
        
        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path);
        
        return res;
    }
}