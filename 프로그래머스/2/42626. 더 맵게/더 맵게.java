import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        
        while(pq.peek() < K && pq.size()>1){
            answer++;
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            pq.add(s1+ s2*2);
        }
        if(pq.peek() < K) answer = -1;
        return answer;
    }
}