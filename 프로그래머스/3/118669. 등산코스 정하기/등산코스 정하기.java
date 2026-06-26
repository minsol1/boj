// import java.util.*;
// import java.io.*;

// class Node implements Comparable<Node>{
//     int num;
//     int w;
    
//     public Node(int num, int w ){
//         this.num = num;
//         this.w = w;
//     }
    
//     public int compareTo(Node o){
//         return this.w - o.w;
//     }
    
// }

// class Solution {
//     public static int N;
//     public static int[][] path;
//     public static HashSet<Integer> gate;
//     public static HashSet<Integer> summit;
//     public static int[] res;
//     public static ArrayList<Node>[] arr;
    
//     public static void bfs(int s){
//         int[] visited = new int[N];
//         Arrays.fill(visited, 10000000);
//         PriorityQueue<Node> pq = new PriorityQueue<>();
//         pq.add(new Node (s,0));
//         visited[s] = 0;
//         int min = 10000000; // 출발지까지 최솟값
        
//         while(!pq.isEmpty()){
//             Node now = pq.poll();
            
//             for(int i =0; i< arr[now.num].size() ; i++){
//                 Node next = arr[now.num].get(i);
//                 int next_w = Math.max(next.w, now.w);
                
//                 if(summit.contains(next.num)) continue;
                
//                 if(visited[next.num] <= next_w) continue;
                
//                 if(gate.contains(next.num)){
//                     if(next_w == res[1]){
//                         if(res[0] > s) res[0] = s;
//                     }
//                     else if(next_w < res[1]){
//                         res[0] = s;
//                         res[1] = next_w;
//                     }
//                     continue;
//                 }
                
//                 visited[next.num] = next_w;
//                 pq.add(new Node(next.num, next_w));
//             }
//         }
        
//     }
    
//     public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
//         N = n+1;
//         path = paths;
//         gate =  new HashSet<>();
//         for(int i : gates){
//             gate.add(i);
//         }
//         summit =  new HashSet<>();
//         for(int i : summits){
//             summit.add(i);
//         }
        
//         res = new int[2];
//         res[1] = 10000000;
//         arr = new ArrayList[N];
        
//         for(int i = 0 ; i< N ; i++){
//             arr[i] = new ArrayList<Node>();
//         }
        
//         for(int i =0; i< paths.length; i++){
//             arr[paths[i][0]].add(new Node(paths[i][1], paths[i][2]));
//             arr[paths[i][1]].add(new Node(paths[i][0], paths[i][2]));
//         }
        
//         Arrays.sort(summits);
//         for(int i =0; i < summits.length; i++){
//             bfs(summits[i]); // 산봉우리 기준 탐색
//         }
        
//         return res;
//     }
// }


import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int num, w;
        
        public Node(int num, int w) {
            this.num = num;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 빠른 조회를 위해 Set 변환
        HashSet<Integer> gateSet = new HashSet<>();
        for (int g : gates) gateSet.add(g);
        
        HashSet<Integer> summitSet = new HashSet<>();
        for (int s : summits) summitSet.add(s);

        // 인접 리스트 구축
        ArrayList<Node>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];

            // u가 출입구이거나 v가 산봉우리라면: u -> v 단방향만 가능
            // v가 출입구이거나 u가 산봉우리라면: v -> u 단방향만 가능
            if (gateSet.contains(u) || summitSet.contains(v)) {
                adj[u].add(new Node(v, w));
            } else if (gateSet.contains(v) || summitSet.contains(u)) {
                adj[v].add(new Node(u, w));
            } else {
                // 일반 쉼터끼리는 양방향
                adj[u].add(new Node(v, w));
                adj[v].add(new Node(u, w));
            }
        }

        // 다익스트라 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 모든 출입구를 시작점으로 동시에 큐에 삽입
        for (int g : gates) {
            pq.add(new Node(g, 0));
            intensity[g] = 0;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 이미 더 짜임새 있는(작은) intensity로 방문했다면 패스
            if (now.w > intensity[now.num]) continue;
            // 산봉우리에 도달했다면 더 이상 이동하지 않음 (조건 만족)
            if (summitSet.contains(now.num)) continue;

            for (Node next : adj[now.num]) {
                // 다음 노드로 갈 때의 intensity는 현재까지의 intensity와 다음 간선 중 '최댓값'
                int nextMaxW = Math.max(now.w, next.w);
                
                if (intensity[next.num] > nextMaxW) {
                    intensity[next.num] = nextMaxW;
                    pq.add(new Node(next.num, nextMaxW));
                }
            }
        }

        // 정답 찾기: 산봉우리 번호가 낮은 순, intensity가 낮은 순
        Arrays.sort(summits);
        int minSummit = -1;
        int minIntensity = Integer.MAX_VALUE;

        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                minSummit = s;
            }
        }

        return new int[]{minSummit, minIntensity};
    }
}