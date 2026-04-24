import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int e = 0;
        
        for(int[] a : targets){
            // System.out.println(a[0]+" "+ a[1]);
            if(e <= a[0]){
                answer ++;
                e = a[1];
            }
        }
        
        return answer;
    }
}