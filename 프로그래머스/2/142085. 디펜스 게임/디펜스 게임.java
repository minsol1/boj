import java.util.*;
import java.io.*;

class Solution {
    
    public static PriorityQueue<Integer> pq; // 젤큰거 뽑는용
    public static int[] arr;
    public static int K, N;
    
    public static boolean check(int e){
        pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0; 
        
        for(int i =0; i < e ; i++){
            pq.add(arr[i]);
            sum += arr[i];
        }
        
        for(int i =0; i< K ; i++){
            if(pq.isEmpty()) break;
            sum-=pq.poll();
        }
        
        return sum<=N;
    }
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        N = n;
        arr = enemy; 
        K = k;
        int l = 0; 
        int r = enemy.length;
        
        while(l<=r){
            int m = l + (r - l)/2;
            
            if(check(m)){
                l = m+1;
                answer = m;
            }
            else{
                r = m-1;
            }
        }
        
        return answer;
    }
}