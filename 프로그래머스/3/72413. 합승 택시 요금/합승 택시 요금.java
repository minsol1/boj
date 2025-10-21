import java.util.*;

class Node implements Comparable<Node>{
    int e;
    int cost;
    
    public Node(int e, int cost){
        this.e = e ;
        this.cost = cost;
    }
    
    public int compareTo(Node o){
        return cost - o.cost;
    }
}

class Solution {
    public static int[][] arr ;
    
    public static void dik(int s, int[]dest){
        Arrays.fill(dest,Integer.MAX_VALUE);
        dest[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(s,0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i =0; i< arr[now.e].length; i++){
                int cost = arr[now.e][i];
                if(cost == Integer.MAX_VALUE) continue;
                int d = now.cost + cost;
                if(d < dest[i]){
                    q.add(new Node(i,d));
                    dest[i] = d;
                }
            }
        }
        
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //지점 수, 출발, 도착점a,b,요금 
        int[] dests = new int[n]; // 시작
        int[] desta = new int[n]; // 시작
        int[] destb = new int[n]; // 시작
        arr = new int[n][n];
        
        for(int i =0; i< n;i++){
            for(int j =0; j<n ; j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i =0; i< fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int c = fares[i][2];
            arr[start-1][end-1] = c;
            arr[end-1][start-1] = c;
        }
        dik(s-1, dests);
        dik(a-1, desta);
        dik(b-1, destb);
        
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            int c = dests[i]+desta[i]+destb[i];
            res = res < c ? res : c;
        }
        
        return res;
    }
}