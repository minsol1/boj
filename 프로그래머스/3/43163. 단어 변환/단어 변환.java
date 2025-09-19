import java.io.*;
import java.util.*;

class Node{
    char[] str;
    int num;
    
    public Node(char[] str, int num){
        this.str = str;
        this.num = num;
    }
}
class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashMap<String,Integer> hs = new HashMap<>();
        for(String str : words) hs.put(str,0);
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin.toCharArray(),0));
        while(!q.isEmpty()){
            Node now = q.poll();
            
            char[] str = now.str;
            for(int i =0; i < str.length;i++){
                for(int j = 0; j <26; j++){
                    char t = str[i];
                    char c =(char) ('a' + j);
                    if(c > 'z' || c < 'a') continue;
                    str[i] = c;
                    
                    String tem = new String(str);
                    System.out.println(tem);
                    if(hs.containsKey(tem) && hs.get(tem)==0){
                        q.add(new Node(tem.toCharArray(), now.num+1));
                        hs.put(tem,now.num+1);
                        System.out.println("~~~~~"+tem);
                    }
                    str[i] =t;
                }
                
            }
        }
        if(hs.containsKey(target)){
            answer = hs.get(target);
        }
        return answer;
    }
}