import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int idx;
    int cnt;
    
    public Node(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
    
    public int compareTo(Node o){
        return o.idx -idx;
    }
}

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        PriorityQueue<Node> dpq = new PriorityQueue<>();
        PriorityQueue<Node> ppq = new PriorityQueue<>();
        
        for(int i =0; i< n; i++){
            if(deliveries[i] != 0)
                dpq.add(new Node(i+1, deliveries[i]));
            if(pickups[i] != 0)
                ppq.add(new Node(i+1, pickups[i]));
        }
        
        while(!dpq.isEmpty() || !ppq.isEmpty()){
            int max_idx = 0;
            
            int c = cap;
            while(!dpq.isEmpty() && c != 0){
                max_idx = Math.max(max_idx , dpq.peek().idx);
                if(dpq.peek().cnt <= c){
                    c -= dpq.peek().cnt;
                    // System.out.print(dpq.peek().idx+"-");
                    dpq.poll();
                }
                else{
                    dpq.peek().cnt -= c;
                    c = 0;
                }
            }
            
            c = cap;
            while(!ppq.isEmpty()&& c != 0){
                max_idx = Math.max(max_idx , ppq.peek().idx);
                if(ppq.peek().cnt <= c){
                    c -= ppq.peek().cnt;
                    // System.out.print(ppq.peek().idx+"-");
                    ppq.poll();
                    
                }
                else{
                    ppq.peek().cnt -= c;
                    c = 0;
                }
            }
            // System.out.println(max_idx);
            answer+= (max_idx*2);
        }
        
        return answer;
    }
}