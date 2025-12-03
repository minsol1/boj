class Solution {
    public static int gdc(int a, int b){
        if(b==0) return a;
        else return gdc(b, a%b);
    }
    
    public static int lcm(int a, int b){
        return a*b / gdc(a,b);
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i<arr.length; i ++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}