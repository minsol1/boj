import java.io.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int N = d / k;
        
        for(int i = 0 ; i<= N ; i++){
            answer+= (long)(Math.sqrt( (long)d*d-(long)(i*k)*(i*k)) / k )+1;
            // System.out.println((int)(Math.sqrt( d*d-(i*k)*(i*k)) / k )+1);
        }
        return answer;
    }
}