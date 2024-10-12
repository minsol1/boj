import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] su1 = {1,2,3,4,5};
        int[] su2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] su3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1=0;
        int score2=0;
        int score3=0;
        int res =0;
        
        for(int i =0; i<answers.length; i++){
            if(answers[i]== su1[i%5]) score1++;
            if(answers[i]== su2[i%8]) score2++;
            if(answers[i]== su3[i%10]) score3++;
             
        }
       res = res > score1?res : score1;
       res = res > score2?res : score2;
       res = res > score3?res : score3;
        
        if(res == score1){
            arr.add(1);
        }
        if(res == score2){
            arr.add(2);
        }
       if(res == score3){
            arr.add(3);
        }
        return arr.stream()
			.mapToInt(i -> i)
            .toArray();
    }
}