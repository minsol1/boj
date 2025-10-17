import java.util.*;

class Solution {
    public static int[][] map;
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        map = new int[101][101];
        
        ArrayList<Robot> arr = new ArrayList<>();
        for(int i =0; i< routes.length; i++){
            int idx = routes[i][0]-1;
            int x = points[idx][0];
            int y = points[idx][1];
            map[x][y]++; 
            
            ArrayList<int[]> route = new ArrayList<>();
            for(int j =1; j<routes[i].length ; j++){
                int nidx = routes[i][j]-1;
                int nx = points[nidx][0];
                int ny = points[nidx][1];
                
                route.add(new int[]{nx,ny});
            }
            arr.add(new Robot(x,y,route));
            
        }
        for(int i = 0; i <101; i++){
            for(int j = 0; j<101; j++){
                if(map[i][j] >1) answer++;
            }
        }
        
        while(arr.size() > 1){
            ArrayList<Integer> end = new ArrayList<>();
            
            for(int i = arr.size()-1; i >=0; i--){
                Robot r = arr.get(i);
                if(!r.move()){
                    end.add(i);
                }
            }
            
            for(int idx : end){
                arr.remove(idx);
            }
            
            for(int i = 0; i <101; i++){
                for(int j = 0; j<101; j++){
                    if(map[i][j] >1) answer++;
                }
            }
            
        }
        
        return answer;
    }
    
    class Robot{
        int x;
        int y;
        ArrayList<int[]> route;
    
        public Robot(int x, int y, ArrayList<int[]> route){
            this.x = x;
            this.y = y;
            this.route = route;
        }
    
        public boolean move(){// 이동 
            map[x][y]--;
            int[] point = route.get(0);// 목적 포인트 
            
            if(point[0] == x && point[1] == y) {
                route.remove(0);
            }
            
            if(route.size()==0) return false;
            
            point = route.get(0);
            
            if(point[0] != x){
                if(point[0] < x) x--;
                else x++;
            }
            else{
                if(point[1] < y) y--;
                else y++;
            }
            
            map[x][y]++;
            return true;
        }
    }
}






