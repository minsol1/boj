import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arr = new ArrayList<>();  
        
        for(int n : numbers){
            arr.add(n+"");
        }
        
        Collections.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        if (arr.get(0).equals("0")) {
            return "0";
        }
        
        for(String n : arr){
            sb.append(n);
        }
        
        return sb.toString();
    }
}