import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num;
    int cost;
    
    public Node (int num, int cost){
        this.num = num;
        this.cost = cost;
    }
    
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Solution {
    
    public static int N;
    public static int[] visited;
    public static ArrayList<Node>[] arr;
    
    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        visited[1]= 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            for(int i =0; i< arr[now.num].size(); i++){
                int nx =  arr[now.num].get(i).num;
                int nx_dist = now.cost + arr[now.num].get(i).cost;
                
                if(visited[nx] > nx_dist){
                    visited[nx] = nx_dist;
                    
                    pq.add(new Node(nx, nx_dist));
                }
            }
            
        }
        
    }
    
    public int solution(int n, int[][] road, int K) {
        int answer = 0;
        N = n;
        visited = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i =0; i< N+1;i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i =0; i< road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        bfs();
        
        for(int i =1; i<N+1;i++){
            if(visited[i] <= K) {
                answer++;
            }
            
        }

        return answer;
    }
}