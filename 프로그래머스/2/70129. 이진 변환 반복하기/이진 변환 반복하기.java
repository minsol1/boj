import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] res = new int[2];
        int cnt = 0; 
        int cnt0 = 0;
        
        while(!s.equals("1")){
            cnt++;
            int n = 0;
            for(int i =0; i<s.length();i++){
                char c = s.charAt(i);
                if(c =='0'){
                    cnt0++;
                }
                else n++;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            while(n !=0){
                arr.add(n%2);
                n /=2;
            }
            Collections.reverse(arr);
            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append(i);
            }
            s = sb.toString();
        }
        res = new int[]{cnt, cnt0};
        return res;
    }
}