class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int idx = 0;
        
        while(now <= n){
            if(idx < stations.length && stations[idx]-w <=now) {
                now = stations[idx]+w+1; 
                idx++;
                continue;
            }
            answer++;
            now += (2*w+1);
        }
        return answer;
    }
}