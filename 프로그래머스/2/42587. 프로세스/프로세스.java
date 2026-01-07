import java.util.*;

class Node implements Comparable<Node>{
    int prio;
    int loc;
    
    public Node(int prio, int loc){
        this.prio = prio;
        this.loc = loc;
    }
    
    public int compareTo(Node o){
        return o.prio - this.prio;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Node> q = new ArrayDeque<>();
        
        for(int i =0; i< priorities.length ; i++){
            Node node = new Node(priorities[i],i);
            pq.add(node);
            q.add(node);
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.prio == pq.peek().prio){
                if(now.loc == location) break;
                pq.poll();
                answer++;
            }
            else{
                q.add(now);
            }           
        }
        return answer;
    }
}