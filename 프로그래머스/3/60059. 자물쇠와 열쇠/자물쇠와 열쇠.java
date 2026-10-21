import java.util.*;
import java.io.*;
// 돌돌 x 자물쇠 모든 홈 돌기
// 0 홈 1 돌기

class Solution {

    public static int N, M;
    public static int[][] k;
    public static int[][] l;

    public static boolean check(int x, int y){

            for(int i =0; i<N; i++){
                for(int j =0; j< N;j++){
                    int c = i + x;
                    int r = j + y;
                    if (c < 0 || c >= M || r < 0 || r >= M) {
                        if (l[i][j] == 0) return false;
                        continue;
                    }
                    if(l[i][j] ==  k[c][r] ) return false;

                }
            }
            return true;
        }

    public static int[][] rotation(){
        int[][] arr = new int[M][M];

        for(int i =0; i< M; i++){
            for(int j =0; j< M;j++){
                arr[i][j] = k[M - j -1][i];
            }
        }
        return arr;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;
        k = key;
        l = lock;

        for(int x = -N+1 ; x <M; x++){
            for(int y = -N+1 ; y <M; y++){
                for(int i =0; i<4; i++){
                    k = rotation();
                    if(check(x,y)){
                        return true;
                    }
                }
            }
        }

        return answer;
    }
}