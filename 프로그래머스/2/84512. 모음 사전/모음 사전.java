import java.util.*;

class Solution {
    public static ArrayList<String> arr;
    public static char[] aeiou =new char[] {'A','E','I','O','U'};
    
    public static void dfs(char[] word, int cnt, int N){
        if(cnt == N){
            StringBuilder sb = new StringBuilder();
            for(int i =0; i< N ; i++){
                sb.append(word[i]);
            }
            arr.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }
        
        for(int i =0; i< 5;i++){
            word[cnt] = aeiou[i];
            dfs(word, cnt+1, N);
        }
        
    }
    public int solution(String word) {
        arr = new ArrayList<>();
        for(int i =1 ; i<=5 ; i++){
            dfs(new char[5], 0, i);
        }
        
        Collections.sort(arr);
        
        return arr.indexOf(word)+1;
    }
}