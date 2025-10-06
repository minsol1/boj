class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        
        for(int i =0; i<24; i++){
            int now = server[i] * m;
            
            if(players[i] >= now){
                int cnt = (players[i] - now)/m;
                answer += cnt;
                
                for(int j = i ; j< i+k ; j++){
                    if(j>=24) break;
                    server[j] += cnt;
                }
            }
        }
        return answer;
    }
}