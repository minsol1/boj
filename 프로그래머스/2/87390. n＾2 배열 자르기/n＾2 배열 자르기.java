class Solution {
    public int[] solution(int n, long left, long right) {
        int N = (int)(right - left) + 1;
        int[] answer = new int[N];
        int idx = 0;
        for(long i = left; i< right+1;i++){
            int x = (int)(i / n);
            int y = (int)(i % n);
            answer[idx++] = Math.max(x,y)+1;
            
        }
        return answer;
    }
}