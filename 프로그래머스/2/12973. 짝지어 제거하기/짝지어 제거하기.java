import java.util.*;
class Solution
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(char c : arr){
            if(st.isEmpty() || c != st.peek()){
                st.add(c);
            }
            else{
                st.pop();
            }
        }
        int answer = 1;
        if(st.size()>0) answer = 0; 
        return answer;
    }
}