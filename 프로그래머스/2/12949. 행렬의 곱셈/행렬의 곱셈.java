class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int K = arr1[0].length;
        int M = arr2[0].length;
        
        int[][] answer = new int [N][M];
        
        for(int i =0; i< N; i++){
            for(int j =0; j< M; j++){
                for(int x = 0; x<K; x++){
                    answer[i][j] += arr1[i][x]*arr2[x][j];
                }
            }
        }
        return answer;
    }
}