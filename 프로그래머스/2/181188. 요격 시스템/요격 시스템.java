import java.util.*;
class Pos implements Comparable<Pos>{
    int s;
    int e;
    
    public Pos(int s, int e){
        this.s = s;
        this.e = e;
    }
    
    public int compareTo(Pos o){
        return e - o.e;
    }
}

class Solution {
    public static ArrayList<Pos> arr;
    
    public int solution(int[][] targets) {
        int answer = 0;
        arr= new ArrayList<>();
        for(int i =0; i < targets.length; i++){
            int s = targets[i][0];
            int e = targets[i][1];
            arr.add(new Pos(s,e));
        }
        Collections.sort(arr);
        
        int x = 0; 
        for(Pos p : arr ){
            if(p.s >= x){
                x = p.e;
                answer++;
            }
        }
        return answer;
    }
}