class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int S = skill.length;
        int[][] map = new int[N+1][M+1];
        
        for(int i =0; i< skill.length; i++){
            int t = skill[i][0] == 1 ? -1 : 1;
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            int d = skill[i][5] * t;
            
            map[x1][y1] += d;
            map[x1][y2+1] += (d*-1);
            map[x2+1][y1] += (d*-1);
            map[x2+1][y2+1] += d;
        }
        
        
        for(int i =0; i< N+1; i++){
            for(int j =1; j< M+1; j++){
                map[i][j] += map[i][j-1];
            }
        }
        for(int i =1; i< N+1; i++){
            for(int j =0; j< M+1; j++){
                map[i][j] += map[i-1][j];
            }
        }

        
        for(int i =0; i < N; i++){
            for(int j =0; j <M ; j ++){
                if(board[i][j] + map[i][j] >=1) answer++;
            }
        }
        
        return answer;
    }
}