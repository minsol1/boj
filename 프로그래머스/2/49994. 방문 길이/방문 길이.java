class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int N = 13; 
        boolean[][][] visited = new boolean[N][N][4];
        int x = 6;
        int y = 6;
        
        for(int i =0 ; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            int nx = x;
            int ny = y;
            int d = -1; 
            
            if(c == 'U') 
            {
                nx = x-1;
                d = 0;
            }
            if(c == 'D') 
            {
                nx= x +1;
                d = 1;
            }
            if(c == 'R') 
            {
                ny= y +1;
                d = 2;    
            }
            if(c == 'L') 
            {
                ny = y -1;
                d = 3;
            }
            
            if(nx <1 || nx > 11 || ny < 1 || ny > 11) continue;
            
            if(!visited[x][y][d]){
                visited[x][y][d] = true;
                d = d % 2 == 0 ? d+1 : d-1;
                visited[nx][ny][d] = true;
                answer ++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}