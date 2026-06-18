import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a,b) -> a[col-1]== b[col-1]? b[0]-a[0] :a[col-1]- b[col-1]  );
        
        
        for(int i = row_begin-1 ; i< row_end; i++){
            long sum = 0;
            
            for(int j =0; j< data[i].length; j++){
                sum+= (data[i][j]%(i+1));
            }
            
            answer ^=sum;
        }
        return answer;
    }
}