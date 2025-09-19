import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        
        for(int i =0;i<operations.length;i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(str.equals("I")){
                if(tm.containsKey(num)){
                    tm.put(num, tm.get(num)+1);
                }
                else tm.put(num,1);
            }
            else if(!tm.isEmpty()){
                if(num == -1) {
                    int k = tm.firstKey();
                    if(tm.get(k) <=1) tm.remove(k);
                    else tm.put(k,tm.get(k)-1);
                }
                else{
                    int k = tm.lastKey();
                    if(tm.get(k) <=1) tm.remove(k);
                    else tm.put(k,tm.get(k)-1);
                }
            }
        }
        if(tm.isEmpty()) answer = new int[] {0,0};
        else{
            answer =new int[]  {tm.lastKey(),tm.firstKey()};
        }
        return answer;
    }
}