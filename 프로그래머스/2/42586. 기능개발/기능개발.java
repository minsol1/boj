import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 0;
        int cnt = 0;
        int day = 0;
        int N = progresses.length;
        
        while(idx < N){
            int now = progresses[idx];
            
            if(now + speeds[idx] * day >= 100){
                cnt ++;
                idx ++;
                continue;
            }
            else{
                if(cnt != 0)
                    arr.add(cnt);
                day++;
                cnt = 0;
            }
        }
        if(cnt != 0) arr.add(cnt);
        int[] answer = new int[arr.size()];
        for(int i = 0; i< arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}