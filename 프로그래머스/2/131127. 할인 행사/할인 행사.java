import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hm = new HashMap<>(); // 제품, 인덱스
        int res = 0; // 결과 
        int total = 0;// 구입한 물건 수
        
        for(int i =0; i< want.length;i++){
            hm.put(want[i],i);
        }
        
        for(int i = 0 ; i<10 ; i++){
            String str = discount[i];
            if(!hm.containsKey(str)) continue;
            int idx = hm.get(str);
            if(number[idx] > 0) total++;
            number[idx]--;
        }
        
        if(total == 10) res++;
        
        for(int i= 10; i< discount.length; i++){
            String str = discount[i-10];
            if(hm.containsKey(str)){
                int idx = hm.get(discount[i-10]);
                if(number[idx]>=0) total--;
                number[idx]++;
            }
            str = discount[i];
            if(hm.containsKey(str)){
                int idx = hm.get(discount[i]);
                if(number[idx]> 0) total++;
                number[idx]--; 
            }
        
            if(total == 10) res++;
        }
        return res;
    }
}