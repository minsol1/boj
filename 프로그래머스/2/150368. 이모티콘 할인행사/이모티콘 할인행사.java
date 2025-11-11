import java.util.*;
class Solution {
    public static int[] emot;
    public static int[][] user;
    public static int[] rate;
    public static int N;
    public static int cnt;
    public static int money;
    
    public static void dfs(int idx){
        if(idx == N){
            int c = 0;
            int m = 0; 
            
            for(int i =0; i < user.length; i++){
                int sum = 0;
                int r = user[i][0];
                for(int j = 0; j< N ; j++){
                    if(rate[j] >= r){
                        sum += emot[j]*(100-rate[j])*0.01;
                    }
                }
                
                if(sum >= user[i][1]) {
                    c++;
                }
                else{
                    m += sum;
                }
            }
            if(c >cnt){
                cnt = c;
                money = m;
            }
            else if(cnt == c && m > money){
                money = m;
            }
            return;
            
        }
        
        for(int i =4; i>0; i--){
            rate[idx] = i*10;
            dfs(idx+1);
        }
        
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        N = emoticons.length;
        rate = new int[N];
        emot = emoticons;
        user = users;
        cnt = 0; 
        money = 0; 
        
        dfs(0);
        answer[0] = cnt;
        answer[1] = money;
        return answer;
    }
}