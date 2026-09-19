import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    String str;
    
    public Node(String str){
        this.str = str;
    }
    
    public int compareTo(Node o){
        return str.length() - o.str.length();
    }
}
class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2,s.length()-2);
        String[] s_split = s.split("\\}\\,\\{");
        ArrayList<Node> arr = new ArrayList<>();
        
        for(int i =0; i< s_split.length ; i++){
            arr.add(new Node(s_split[i]));
        }
        Collections.sort(arr);
        System.out.println(arr.get(0).str);
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.size()];
        for(int i =0; i< arr.size(); i++){
            String[] str = arr.get(i).str.split(",");
            
            for(String c : str){
                if(!set.contains(c)){
                    set.add(c);
                    answer[i]=  Integer.parseInt(c);
                    break;
                }
            }
            
        }
        return answer;
    }
}
