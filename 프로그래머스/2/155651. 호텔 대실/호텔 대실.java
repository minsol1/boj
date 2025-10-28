import java.util.*;
class Solution {

    public int solution(String[][] book_time) {
        int N = 24*60;
        int res = 0;
        int[] room = new int[N];
        
        for(int i = 0; i< book_time.length;i++){
            StringTokenizer st = new StringTokenizer(book_time[i][0],":");
            int s = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        
            st = new StringTokenizer(book_time[i][1],":");
            int e = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken())+10;
            
            if(e >= N) e = N-1;
            for(int j = s ; j < e; j++){
                room[j]++;
            }
        }
        
        for(int i = 0; i<N; i++){
            res = res > room[i] ? res : room[i];
        }
        return res;
    }
}