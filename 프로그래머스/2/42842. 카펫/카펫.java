class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 3; i < 2000000 ; i++){
            for(int j =i; j < 2000000 ; j++){
                if( 2*(j+i-1)-2 == brown && (j-2)*(i-2)== yellow ){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}