import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> cnt = new ArrayList<>();
        
        int N = tangerine.length;
        int idx = 0;
        for(int i =0; i< N ; i++){
            if(hm.containsKey(tangerine[i])){
                int n = hm.get(tangerine[i]);
                cnt.set(n, cnt.get(n)+1);
            }
            else{
                hm.put(tangerine[i], idx);
                cnt.add(1);
                idx++;
            }
        }
        Collections.sort(cnt);
        Collections.reverse(cnt);
        
        int sum = 0;
        for(int n : cnt){
            sum+=n;
            answer++;
            if(sum>= k){
                break;
            }
        }
        
        
        return answer;
    }
}