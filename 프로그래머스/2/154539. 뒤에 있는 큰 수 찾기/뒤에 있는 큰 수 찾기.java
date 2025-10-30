import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Stack<Integer> st = new Stack<>();
        
        for(int i = N-1; i>=0; i--){
            while(!st.isEmpty() && numbers[i] >=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                answer[i] = -1;
                st.add(numbers[i]);
                continue;
            }
            if(numbers[i] < st.peek()){
                answer[i] = st.peek();
                st.add(numbers[i]);
            }
            
        }
        return answer;
    }
}