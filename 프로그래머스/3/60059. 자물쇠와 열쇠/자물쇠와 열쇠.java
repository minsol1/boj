class Solution {
    public static int N, M;
    public static int[][] spare;
    
    public static void rotation(){
        int[][] temp = new int[M][M];
        
        for(int i = 0; i<M; i++){
            for(int j =0; j<M; j++){
                temp[i][j] = spare[M-j-1][i];
            }
        }
        spare = temp;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;
        spare = key;
        
        for(int r =0; r< 4 ; r++){// 4바퀴 돌기 
            rotation(); // 키 회전 
            
            for(int x = -N+1 ; x < M ; x++){
                for(int y = -N+1; y < M ; y++){
                    
                    boolean f = true;
                    for(int i = 0; i < N ; i++){
                        for(int j = 0; j < N; j++){
                            
                            
                            if(i + x < 0 || i + x >= M || j + y < 0 || j + y >= M ) {
                                if(lock[i][j] == 0) f = false;
                                continue;
                                
                            }
                            if(spare[i+x][j+y] == 1 && lock[i][j] == 1) {
                                f = false;
                                continue;
                            }
                            if(spare[i+x][j+y] == 0 && lock[i][j] == 0) {
                                f = false;
                                break;
                            }
                            
                            
                        }
                    }
                    
                    if(f){
                        return (true);
                    }
                    
                    
                }
            }
            
        }
        
        return answer;
    }
}