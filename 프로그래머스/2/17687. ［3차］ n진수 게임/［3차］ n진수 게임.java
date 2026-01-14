import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; str.length() < t*m ; i++ ){
            str.append(Integer.toString(i,n).toUpperCase());
        }
        System.out.println(str);
        
        for(int i = p-1 ; sb.length() < t ; i+=m){
            sb.append(str.charAt(i));
        }
        
        return sb.toString();
    }
}