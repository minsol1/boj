class Solution {
    public int[] solution(int n, long left, long right) {
        long len = right - left + 1;
        int[] answer = new int[(int) len];
        
        for(int i =0; i< len; i++){
            long c = (left + i)/n;
            long r = (left + i)%n;
            
            long num = Math.max(c,r)+1;
            answer[i] = (int)num;
        }
        return answer;
    }
}