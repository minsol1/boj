import java.util.*;
import java.io.*;

class Solution {
    
    public static int[] cnt;
    public static int N, res;
    public static ArrayList<Integer>[] arr;
    
    public static void dfs(int sh,int w, ArrayList<Integer> next_node){
        for(int now : next_node){
            int n_sh = sh;
            int n_w = w;
            if(cnt[now]==0){
                n_sh++;
            }
            else{
                n_w ++;
            }
            
            if(n_sh <= n_w) continue;
            
            res = res > n_sh ? res : n_sh;
            
            ArrayList<Integer> node = new ArrayList<>(next_node);
            node.remove(Integer.valueOf(now));

            for (int next : arr[now]) {
                node.add(next);
            }

            dfs(n_sh, n_w, node);
        }
        
    }
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        res = 0; 
        cnt = info;
        arr = new ArrayList[N];
        ArrayList<Integer> next_node = new ArrayList<>();
        
        for(int i =0; i< N ; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i< N-1; i++){
            arr[edges[i][0]].add(edges[i][1]);
        }
        
        next_node.add(0);
        dfs(0,0,next_node);
        
        return res;
    }
}