class Solution
{
    public static char[] arr;
    public static int N;

    
    public int solution(String s)
    {
        int answer = 0;
        arr = s.toCharArray();
        N = s.length();
        
        for(int i =0; i<N;i++){
            int l = i;
            int r = i;
            int n = 0;
            
            while(l >=0 && r < N && arr[l] == arr[r]){
                answer = Math.max(answer, r-l+1);
                l--;
                r++;
            }
        }
        
        for(int i =0; i<N;i++){
            int l = i;
            int r = i+1;
            int n = 0;
            
            while(l >=0 && r < N && arr[l] == arr[r]){
                answer = Math.max(answer, r-l+1);
                l--;
                r++;
            }
        }
    
        return answer;
    }
}