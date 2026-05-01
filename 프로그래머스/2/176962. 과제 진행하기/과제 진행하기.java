import java.util.*;

class Task implements Comparable<Task>{
    String name;
    int start;
    int remain;
    
    public Task (String name, int start, int remain){
        this.name = name;
        this.start = start;
        this.remain = remain;
    }
    
    public int compareTo(Task o){
        return this.start - o.start;
    }
}


class Solution {
    
    public static int mint(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h*60 + m;
        
    }
    
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<String>();
        PriorityQueue<Task> pq = new PriorityQueue<>();
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        for(int i = 0; i< plans.length ; i++){            
            pq.add(new Task(plans[i][0], mint(plans[i][1]), Integer.parseInt(plans[i][2]) ));
        }
        
        int time = 0;
        
        while(!pq.isEmpty()){
            Task now = pq.poll();
            System.out.println(now.name);
            System.out.println("1");
            
            if(pq.isEmpty()){
                answer.add(now.name);
                System.out.println("2");
                break;
            }
            
            time = pq.peek().start - now.start;
            
            if(time >= now.remain){
                answer.add(now.name);
                time -=now.remain;
                System.out.println(3);
                
                
                if(stack.isEmpty()) continue;
                while(time > 0 && !stack.isEmpty()){
                    System.out.println(4);
                    String nx = stack.peek();
                    
                    if(hm.get(nx) <= time){
                        answer.add(nx);
                        time -= hm.get(nx);
                        stack.pop();
                    }
                    else{
                        hm.put(nx, hm.get(nx) - time);
                        time = 0;
                    }
                    
                }
                
            }
            else{
                System.out.println(5);
                stack.push(now.name);
                hm.put(now.name, now.remain - time);
                System.out.println("remain"+ now.name+" : "+( now.remain - time) );
            }
            
            
        }
        
        while(!stack.isEmpty()){
            System.out.println(6);
            answer.add(stack.pop());
        }
        
        String[] res =new String[answer.size()];
        for(int i =0; i< answer.size() ; i++){
            res[i] = answer.get(i);
        }
        return res;
    }
}