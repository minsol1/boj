import java.util.*;

class Work implements Comparable<Work>{
    String name;
    int start;
    int time;
    
    public Work(String name, int start, int time){
        this.name = name;
        this.start = start;
        this.time = time;
    }
    
    public int compareTo(Work o){
        return this.start - o.start;
    }
}
class Solution {
    public static int getTime(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h*60+m;
    }
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] res = new String[N];
        int idx = 0;
        PriorityQueue<Work> pq = new PriorityQueue<>();
        Stack<Work> st = new Stack<>();
        
        for(int i =0; i< N; i++){
            String name = plans[i][0];
            int start = getTime(plans[i][1]);
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Work(name,start, time));
            
        }
        
        int now = pq.peek().start;
        int next = pq.peek().start;
        
        while(!pq.isEmpty() || !st.isEmpty()){
            Work w = null;
            if(now < next ){
                if(!st.isEmpty()){
                    w = st.pop();
                }
                else now = next;
            }
            else {
                w= pq.poll();
                
                if(!pq.isEmpty()) next = pq.peek().start;
                else next = Integer.MAX_VALUE;
            }
            if(w == null) continue;
            
            if(now+w.time > next){
                w.time = now+w.time - next;
                st.add(w);
                now = next;
            }
            else{
                res[idx++] = w.name;
                now += w.time;
            }
        }
        return res;
    }
}


