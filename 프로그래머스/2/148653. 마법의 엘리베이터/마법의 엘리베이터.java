import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int res = 0;
        while(storey >0){
            int tem = storey%10;
            storey /=10;
            
            if(tem == 5){
                if(storey%10 >=5){
                    res += 10-tem;
                    storey++;
                }
                else{
                    res+=tem;
                    
                }
            }
            else if(tem < 5){
                res+= tem;
            }
            else{
                res+= 10 -tem;
                storey++;
            }
        }
        
        return res;
        
    }
}