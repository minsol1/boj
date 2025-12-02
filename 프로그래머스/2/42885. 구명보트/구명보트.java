import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int N = people.length;
        int l = 0; 
        int r = N-1;
        int cnt = 0;
        
        while(l < r){
            if(people[l]+ people[r] <= limit){
                cnt++;
                l++;
                r--;
            }
            else{
                r--;
            }
        }
        
        int answer = N - cnt;
        
        return answer;
    }
}