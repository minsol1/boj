import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = speeds.length;
        int[] need = new int[N];
        int[] res;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i< N ; i++){
            need[i] = (100 - progresses[i]) /speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0 ) need[i]++;
        }
        
        int idx = -1; 
        int day = 0;
        
        for(int i =0; i< N; i++){
            if(need[i] > day){
                day = need[i];
                idx++;
                arr.add(1);
            }
            else{
                arr.set(idx, arr.get(idx) +1);
            }
        }
        res = new int[arr.size()];
        for(int i =0;i< arr.size(); i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}