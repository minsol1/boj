import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int day = 0;
        
        for(int i =0; i< progresses.length; i++){
            if(progresses[i] + day*speeds[i] >= 100) continue;
            
            day = ( 100 - progresses[i] ) / speeds[i] ;
            if(( 100 - progresses[i] ) % speeds[i]  >0) day++;
            // System.out.println(day);
            
            int cnt = 1;
            for(int j =i+1; j < progresses.length ; j++){
                if(progresses[j] + day*speeds[j] >= 100) cnt++;
                else break;
            }
            
            res.add(cnt);            
        }
        
        int[] answer = new int[res.size()];
        for(int i =0; i< res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}