import java.util.*;
class Solution {
    public static HashMap<String , Integer> hm;
    public static int[] arr;
    public static int[] res; 
    
    public static void dfs(int s , int m){
        if(s == 0) return;
        int now = m - m/10;
        int next = m/10;
        
        res[s] += now;
        
        if(next > 0){
            dfs(arr[s], next);
        }
        
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int N = enroll.length;
        hm = new HashMap<>();
        arr = new int[N +1];
        res = new int[N +1];
        hm.put("-", 0);
        for(int i = 0; i< N ; i++){
            hm.put(enroll[i],i+1 );
        }
        for(int i =0; i < N ; i++){
            int idx = hm.get(referral[i]);
            arr[i+1] = idx;
        }
        for(int i = 0 ; i< seller.length ; i++){
            int idx = hm.get(seller[i]);
            dfs(idx, amount[i]*100);
        }
        int[] answer = new int[N];
        for(int i = 1; i< N+1 ; i ++){
            answer[i-1] = res[i];
        }
        
        return answer;
    }
}