import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.replaceAll("\\{\\{","").replaceAll("\\}\\}","")
            .replaceAll("\\},\\{","-");
        
        ArrayList<String[]>arr = new ArrayList<>();
        String[] set  = s.split("-");
        
        for(String str : set){
            arr.add(str.split(","));
        }
        Collections.sort(arr, (o1,o2) -> o1.length - o2.length);
        
        int[] res = new int[arr.size()];
        int idx = 0; 
        HashSet<Integer> hs = new HashSet<>();
        for(String[] a : arr){
            for(String num : a){
                int n = Integer.parseInt(num);
                if(!hs.contains(n)){
                    res[idx++] = n;
                    hs.add(n);
                }
            }
        }
        
        return res;
    }
}