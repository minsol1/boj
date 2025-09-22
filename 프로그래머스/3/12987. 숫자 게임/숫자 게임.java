import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        
        for(int i =0; i<A.length;i++){
            while(idx< B.length &&A[i] >=B[idx]){
                idx++;
            }
            
            if(idx>= B.length) break;
            
            if(A[i] <B[idx]){
                idx++;
                answer++;
                continue;
            }
        }
        return answer;
    }
}