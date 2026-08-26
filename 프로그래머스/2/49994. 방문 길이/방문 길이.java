import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dirs) {
        
        int x = 5; 
        int y = 5; 
        boolean[][][] visited =new boolean[11][11][4];
        int res = 0;
        
        for(int i =0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            int d = 0;
            int nd = 0;
            int nx = x;
            int ny = y;
            
            if(c == 'U'){
                x++;
                d = 0;
                nd = 2;
            }
            if(c == 'R'){
                y++;
                d = 1;
                nd = 3;
            }
            if(c == 'D'){ 
                x--;
                d = 2;
                nd= 0;
            }
            if(c == 'L'){
                y--;
                d = 3;
                nd = 1;
            }
            
            if(x < 0) x = 0;
            if(x > 10) x = 10;
            if(y < 0) y = 0;
            if(y > 10) y = 10;
            
            if(nx == x && ny == y) continue;
            
            if(!visited[x][y][d]){
                res++;
                visited[x][y][d] = true;
                visited[nx][ny][nd] = true;
            }
        }
        
        return res;
    }
}