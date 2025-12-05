class Solution
{
    public int solution(int n, int a, int b)
    {
        int res = 0;
        
        while(a!=b){
            res++;
            a = (a+1)/2;
            b = (b+1)/2;
            
        }
        return res;
    }
}