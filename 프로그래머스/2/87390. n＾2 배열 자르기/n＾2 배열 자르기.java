class Solution {
    public int[] solution(int n, long left, long right) {
        int N = (int)(right - left) + 1;
        int[] answer = new int[N];
        
        for(int i =0; i< N; i++){
            long num = left + i;
            long x = num/n+1;
            long y = num%n+1;
            answer[i] =(int)( x > y? x : y);
        }
        return answer;
    }
}