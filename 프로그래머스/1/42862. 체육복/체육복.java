import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cnt = new int[n+2];
        Arrays.fill(cnt,1);
        cnt[0]=0;
        cnt[n+1]=0;
        
        for(int num : lost){
            cnt[num]--;
        }
        for(int num : reserve){
            cnt[num]++;
        }
        
        for(int i =1; i< n+1 ; i++){
            if(cnt[i]> 0){
                answer++;
                continue;
            } 
            
            if(cnt[i-1] > 1){
                answer++;
                cnt[i-1]--;
            }
            else if(cnt[i+1] > 1){
                answer++;
                cnt[i+1]--;
            }
            
        }
        
        return answer;
    }
}