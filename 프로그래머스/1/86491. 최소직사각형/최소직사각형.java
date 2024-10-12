class Solution {
    
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i =0;i< sizes.length; i++){
            if(sizes[i][0]> sizes[i][1]){
            int tem = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = tem;                
            }

        }
        int w = 0;
        int h = 0;
        for(int i =0; i< sizes.length; i++){
            w = sizes[i][0]> w ?sizes[i][0]:w ;
            h = sizes[i][1]> h ?sizes[i][1]:h ;
        }
        answer = w*h;
        return answer;
    }
}