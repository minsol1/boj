import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int sum;
    int a;
    int b;
    
    public Node(int a, int b){
        this.sum = a+b;
        this.a = a;
        this.b = b;
    }
    
    public int compareTo(Node o){
        
        if(a == o.a){
            return b- o.b;
        }
        return o.a - a;
    }
    
}
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        // 완호 점수
        int wsum = scores[0][0] +  scores[0][1];
        int wa =  scores[0][0];
        int wb =  scores[0][1];
        
        ArrayList<Node> arr = new ArrayList<>();
        
        for(int i =0; i< scores.length; i++){
            
            if(scores[i][0]> wa && scores[i][1] >wb) { // 완호 인센못받는 경우
                answer = -1;
                return answer;
            }
            
            if(scores[i][0]+scores[i][1] > wsum) // 완호보다 점수 높은거만보기 
                arr.add(new Node(scores[i][0],scores[i][1]));
        }
        
        Collections.sort(arr);
        
        // 인센 못받는 애들 거르기
        
        int pre = 0;
        int maxb = 0;
        
        for(int i =0; i<arr.size(); i++){
            Node now = arr.get(i);
            if(pre != now.a){
                if(maxb <= now.b) {
                    answer++;
                    pre = now.a;
                    maxb = now.b;
                }
            }
            else {
                if(maxb <= now.b) {
                    answer++;
                    maxb = now.b;
                }
            }
        }
        
        return answer+1;
    }
}