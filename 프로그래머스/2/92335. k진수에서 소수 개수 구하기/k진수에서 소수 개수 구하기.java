import java.util.*;

class Solution {

    public boolean isPrime(long n){
        if(n <=1) return false;
        
        for(long i = 2; i<= n/i ; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        String[] arr = str.split("0");
        
//         for(int i =0; i<str.length(); i++){
//             int c = str.charAt(i) - '0';
            
//             if(c == 0){
//                 if(isPrime(num)) answer++;
//                 num = 0;
//                 continue;
//             }
//             num = num*10 + c;
            
//         }
        
//         if(num != 0 && isPrime(num)){
//             answer++;
//         } 
        
        for(String num : arr){
            if("".equals(num)) continue;
            if(isPrime(Long.parseLong(num))){
                answer++;
            } 
            
        }
        
        return answer;
    }
}