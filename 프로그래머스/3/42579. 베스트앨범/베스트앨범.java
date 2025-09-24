import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int num;
        String g;
        int p;
        int h;
        
        public Node(int num, String g, int p){
            this.num = num;
            this.g = g;
            this.p = p;
        }
        
        public int compareTo(Node o){
            if(h== o.h){
                if(o.p == p) return num - o.num;
                return o.p - p;
            }
            return o.h - h;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        Node[] arr = new Node[N];
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(int i =0; i < N;i++){
            arr[i] = new Node(i,genres[i],plays[i]);
            hm.put(genres[i], hm.getOrDefault(genres[i],0)+plays[i]);
        }
        for(int i =0; i < N;i++){
            arr[i].h = hm.get(arr[i].g);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N ; i ++){
            if(hm2.getOrDefault(arr[i].g ,0) <2){
                answer.add(arr[i].num);
                hm2.put(arr[i].g , hm2.getOrDefault(arr[i].g,0)+1);
            }
            
        }
        int[] res = new int[answer.size()];
        for(int i =0; i<answer.size();i++){
            res[i] = answer.get(i);
        }
        return res;
    }
}