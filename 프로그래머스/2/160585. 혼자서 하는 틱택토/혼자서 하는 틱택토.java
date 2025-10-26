class Solution {
    public static String[] arr;
    public static int ocnt;
    public static int xcnt;
    public static int o;
    public static int x;
    
    
    public static boolean cnt(){
        o = 0;
        x = 0;
        for(int i =0; i < 3; i++){
            for(int j=0; j<3; j++){
                char c = arr[i].charAt(j);
                if(c == 'O') o++;
                else if(c == 'X')x ++;
            }
        }
        
        if(o ==x || o ==x+1) return true;
        return false;
        
    }
    public static int bingo(char c){
        int cnt = 0; 
        for(int i =0; i<3 ; i++){
            boolean f = true;
            for(int j = 0; j<3 ; j++){
                if(arr[i].charAt(j)!=c) f = false;
            }
            if(f) cnt++;
        }
        
        for(int i =0; i<3 ; i++){
            boolean f = true;
            for(int j = 0; j<3 ; j++){
                if(arr[j].charAt(i)!=c) f = false;
            }
            if(f) cnt++;
        }
        
        if(arr[0].charAt(0)==c && arr[1].charAt(1)==c &&arr[2].charAt(2)==c ) cnt++;
        
        if(arr[2].charAt(0)==c && arr[1].charAt(1)==c &&arr[0].charAt(2)==c ) {
            cnt++;
        }
        return cnt;
    }
    public int solution(String[] board) {
        arr = board;
        if(!cnt()) {
            System.out.println("11");
            return 0;
        }
        ocnt = bingo('O');
        xcnt = bingo('X');
        if(ocnt > 0 && xcnt > 0) return 0; 
        if(ocnt > 0 && o == x) return 0; 
        if(xcnt > 0 && o > x) return 0; 
        return 1;
        
    }
}