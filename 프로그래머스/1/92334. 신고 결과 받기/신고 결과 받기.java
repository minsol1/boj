import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length; // 유저 수
        int[] answer = new int[N]; 
        HashMap<String, Integer> idx = new HashMap<>(); // 유저 인덱스 
        HashMap<String, HashSet<String>> report_user = new HashMap<>(); // 신고한 유저 리스트 
        
        int[] cnt = new int[N]; // 신고당한 횟수
        
        for(int i =0; i< N; i++){
            idx.put(id_list[i], i);
        }
        
        StringTokenizer st;
        
        for(int i =0; i<report.length ; i++ ){
            st = new StringTokenizer(report[i]);
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            
            if(!report_user.containsKey(str2)){
                report_user.put(str2, new HashSet<>());
            }
            if(!report_user.get(str2).contains(str1)){
                report_user.get(str2).add(str1);
                cnt[idx.get(str2)]++;
            }
            
        }
        
        for(int i =0; i< N; i++){
            if(cnt[i] >= k){
                String user = id_list[i];
                
                for(String s : report_user.get(user)){
                    answer[idx.get(s)]++;
                    // System.out.println(user +" "+ s);
                }
            }
        }
        
        
        
        return answer;
    }
}