import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num;
    int w;
    
    public Node(int num, int w ){
        this.num = num;
        this.w = w;
    }
    
    public int compareTo(Node o){
        return this.w - o.w;
    }
    
}

class Solution {
    public static int N;
    public static HashSet<Integer> gate;
    public static HashSet<Integer> summit;
    public static int[] res;
    public static int[] dist;
    public static int[] visited;
    public static ArrayList<Node>[] arr;
    public static PriorityQueue<Node> pq;
    
    public static void bfs(){

        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if (now.w > visited[now.num]) continue;
            for(int i =0; i< arr[now.num].size() ; i++){
                Node next = arr[now.num].get(i);
                int next_w = Math.max(next.w, now.w);
                
                if(gate.contains(next.num)) continue;
                
                if(summit.contains(next.num)){
                    dist[next.num] = Math.min(dist[next.num], next_w);
                    continue;
                }
                
                if(visited[next.num] > next_w){
                    visited[next.num] = next_w;
                    pq.add(new Node(next.num, next_w));
                }
            }
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n+1;
        gate =  new HashSet<>();
        for(int i : gates){
            gate.add(i);
        }
        summit =  new HashSet<>();
        for(int i : summits){
            summit.add(i);
        }
        dist = new int[N];
        
        res = new int[2];
        res[1] = 10000001;
        arr = new ArrayList[N];
        
        visited = new int[N];
        Arrays.fill(visited, 10000001);
        Arrays.fill(dist, 10000001);
        pq = new PriorityQueue<>();
        
        for(int i = 0 ; i< N ; i++){
            arr[i] = new ArrayList<Node>();
        }
        
        for(int i =0; i< paths.length; i++){
            arr[paths[i][0]].add(new Node(paths[i][1], paths[i][2]));
            arr[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
        }
        
        for(int i :gates ){
            pq.add(new Node (i,0));
            visited[i] = 0;
        }
        
        bfs();
        
        // for(int i = 1; i<N ; i++){
        //     if(res[1] > dist[i]){
        //         res[0] = i;
        //         res[1] = dist[i];
        //     }
        // }
        
        Arrays.sort(summits); 
        
        for(int s : summits){
            if(res[1] > dist[s]){
                res[0] = s;
                res[1] = dist[s];
            }
        }
        
        return res;
    }
}
