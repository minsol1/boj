import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 1; i<= 26 ; i++ ){
            char c = (char)(i - 1 + 'A');
            
            hm.put(Character.toString(c), i);
        }
        int idx = 0;
        while(idx< msg.length()){
            StringBuilder sb = new StringBuilder();
            int n = 0;
            
            for(int j = idx; j< msg.length(); j++){
                sb.append(msg.charAt(j));
                
                if(hm.containsKey(sb.toString())){
                    idx++;
                    n = hm.get(sb.toString());
                    continue;
                } 
                hm.put(sb.toString(), hm.size() + 1);
                break;
            }
            arr.add(n);
        }
        
        int[] res = new int[arr.size()];
        for(int i =0; i< arr.size(); i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}