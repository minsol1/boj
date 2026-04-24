import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int l =0;
        int r = people.length-1;
        
        while(l<=r){
            // System.out.print(people[l] + " "+people[r] );
            
            if(people[l] + people[r] <= limit){
                answer ++;
                l++;
                r--;
                // System.out.println("ff" );
            }
            else{
                answer++;
                r--;
                // System.out.println("dd");
            }
            
            if(l==r){
                answer ++;
                break;
            }
            
        }
        return answer;
    }
}