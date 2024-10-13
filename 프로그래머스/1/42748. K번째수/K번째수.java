import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int s = commands[i][0];
            int e = commands[i][1];
            int k = commands[i][2];
            
            int[] arr = new int[e-s+1];
            for(int j=s-1 ; j<e;j++){
                arr[j-s+1]= array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[k-1];
        }
        return answer;
    }
}