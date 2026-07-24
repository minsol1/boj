import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        answer = new_id.toLowerCase();
        
        //2단계
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<answer.length(); i++){
            char c = answer.charAt(i);
            
            if(!(c<='z' && c >='a') && !(c>='0' && c<='9') && c!='-' && c!='_' && c!='.') continue;
            
            sb.append(c);
        }
        answer = sb.toString();
        
        // 3단계
        sb = new StringBuilder();
        char pre = answer.charAt(0);
        sb.append(pre);
        
        for(int i =1; i<answer.length(); i++){
            char c = answer.charAt(i);
            
            if(pre == '.' && c == '.') continue;
            
            sb.append(c);
            pre = c;
        }
        answer = sb.toString();
        
        // 4단계
        if(answer.charAt(0) == '.') answer = answer.substring(1);
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
        } 
        
        //5 
        if(answer.length() == 0 ){
            answer = "a";
        }
        
        //6
        if(answer.length() >= 16 ){
            answer = answer.substring(0,15);
            if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }   
        }
        
        //7
        int n = answer.length();
        if(n < 3){
            sb =new StringBuilder(answer);
            for(int i =0; i + n <3 ; i++){
                sb.append(answer.charAt(n-1));
            }
            answer = sb.toString();
        }
        
        
        
        System.out.println(answer);
        return answer;
    }
}