import java.util.*;
// import java.io.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int N = elements.length;
        
        for(int i = 1; i <=N ; i++){
            int sum =0;
            
            for(int j = 0; j<i; j++){
                sum+=elements[j];
            }
            set.add(sum);
            
            // System.out.print(i+ ": "+sum+" ");
            
            for(int j =0; j< N ; j++){
                int e = (j + i)%N;
                sum-=elements[j];
                sum+=elements[e];
                
                set.add(sum);
                // System.out.print(sum+" ");
            }
            
            // System.out.println("");
        }
        return set.size();
    }
}