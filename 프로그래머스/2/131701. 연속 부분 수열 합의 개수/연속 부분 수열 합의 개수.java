import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int N = elements.length;
        
        for(int i =0; i< N; i++){
            int sum =0;
            for(int j = 0; j < N ; j++){
                sum += elements[(i+j)%N];
                hs.add(sum);
            }
        }
        
        return hs.size();
    }
}