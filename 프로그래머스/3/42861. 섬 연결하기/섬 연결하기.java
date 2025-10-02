import java.util.*;

class Node implements Comparable<Node>{
    int e; 
    int c;
    
    public Node(int e, int c){
        this.e = e;
        this.c = c;
    }
    
    public int compareTo(Node o){
        return c - o.c;
    }
}

class Solution {
    public static int N,res;
    public static ArrayList[] arr;
    public static boolean[] visited;
    
    public static void prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.e]) continue;
            
            visited[now.e] = true;
            res += now.c;
            
            for(int i =0; i< arr[now.e].size(); i++){
                Node next = (Node)arr[now.e].get(i);
                
                if(!visited[next.e]){
                    pq.add(new Node(next.e, next.c));
                }
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        res = 0;
        N = n;
        arr = new ArrayList[n+1];
        visited = new boolean[N+1];
        
        for(int i =0; i<N+1; i++){
            arr[i] = new ArrayList<Node>();
        }
        
        for(int i =0; i < costs.length ; i++){
            int s = costs[i][0];
            int e = costs[i][1];
            int c = costs[i][2];
            
            arr[s].add(new Node(e,c));
            arr[e].add(new Node(s,c));
        }
        
        prim();
        
        return res;
    }
}