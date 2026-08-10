import java.util.*;
import java.io.*;

class Solution {
    
    public int getTime(String str){
        StringTokenizer st = new StringTokenizer(str,":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h*60 + m;
        
    }
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer,Integer> log = new HashMap<>();
        Map<Integer, Integer> total = new TreeMap<>();
        
        for(int i =0; i< records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = getTime(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            if(type.equals("IN"))
                log.put(num,time);
            else{
                int t =  time - log.get(num);
                total.put(num, total.getOrDefault(num,0) +t);
                log.remove(num);
            }
        }
        
        for(int n : log.keySet()){
            int t =  getTime("23:59") - log.get(n);
            total.put(n, total.getOrDefault(n,0) +t);
        }
        
        int[] answer = new int[total.size()];
        int idx = 0;

        for(int n : total.values()){
            int cost = fees[1] ;
            if(n > fees[0]){
                int exTime = n - fees[0];
                cost += (int) Math.ceil((double) exTime / fees[2]) * fees[3];
            }
            
            answer[idx++] = cost;
            
        }
        
        return answer;
    }
}