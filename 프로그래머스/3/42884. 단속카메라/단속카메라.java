import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1,o2)->{
            if(o1[1]== o2[1]) return o1[0] -o2[0];
            return o1[1]-o2[1];
        });
        
        int c = Integer.MIN_VALUE;
        
        for(int i =0; i<routes.length;i++){
            if(routes[i][0]> c){
                answer++;
                c = routes[i][1];
            }
            
        }
        
        return answer;
    }
}