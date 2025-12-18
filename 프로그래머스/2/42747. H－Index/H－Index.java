import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int N = citations.length;
        
        for(int i =0; i< N; i++){
            int c = citations[i];
            
            if(N-i <= c ){
                answer = N-i;
                // System.out.println(N-i);
                break;
            }
        }
        
        return answer;
    }
}