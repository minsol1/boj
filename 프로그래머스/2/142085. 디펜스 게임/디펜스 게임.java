import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i =0; i< enemy.length; i++){
            if(n>= enemy[i]){
                answer ++;
                n-=enemy[i];
                pq.add(enemy[i]);
            }
            else{
                if(k>0){
                    
                    if(!pq.isEmpty()){
                        if(pq.peek() > enemy[i]){
                            n+=pq.poll();
                            n-=enemy[i];
                            pq.add(enemy[i]);
                        }
                    }
                    answer++;
                    k--;
                    
                }
                else break;
            }
        }
        return answer;
    }
}