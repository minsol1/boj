import java.util.*;

public class Solution {

    public int solution(int n) {
        int res = 0; 
        
        while(n !=0){
            if(n %2 == 0){
                n/=2;
            }
            else{
                res++;
                n--;
            }
        }
        return res;
    }
}