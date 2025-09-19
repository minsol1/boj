import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        for(int i = 0; i<n;i++){
            if(pq.isEmpty()) break;
            int t = pq.poll();
            if(t>1) pq.add(t-1);
        }
        for(int w: pq){
            answer += w*w;
        }
        
        return answer;
    }
}