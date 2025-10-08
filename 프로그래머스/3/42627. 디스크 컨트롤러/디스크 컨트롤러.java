import java.util.*;

class Node implements Comparable<Node>{
    int start;
    int cost;
    
    public Node(int start, int cost){
        this.start = start;
        this.cost = cost;
    }
    
    public int compareTo(Node o){
        if(cost == o.cost){
            return start - o.start;
        }
        return cost - o.cost;
    }
    
}
class Solution {
    public int solution(int[][] jobs) {
        int sum = 0;
        int N = jobs.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int time = 0; 
        int idx = 0;
        while(idx < N || !pq.isEmpty()){
            
            while(idx < N && jobs[idx][0] <= time){
                pq.add(new Node(jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){
                time++;
                continue;
            } 
            else{
                Node now = pq.poll();
                System.out.println(time+" "+now.start +" "+ now.cost);
                time += now.cost;
                sum += time - now.start;
            }
        }
        
        return sum/N;
    }
}