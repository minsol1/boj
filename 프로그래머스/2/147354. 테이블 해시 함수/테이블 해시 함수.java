import java.util.*;

class Data implements Comparable<Data>{
    int[] row;
    
    public static int col;
    
    public Data(int[] row){
        this.row = row;
    }
    
    public int compareTo(Data o){
        if(o.row[col-1] == this.row[col-1]){
            return o.row[0] - this.row[0];
        }
        else{
            return this.row[col-1] - o.row[col-1];
        }
    }
    
}
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        ArrayList<Data> arr = new ArrayList<>();
        int res = 0;
        
        for(int i =0; i< data.length;i++){
            arr.add(new Data(data[i]));
        }
        Data.col = col;
        
        Collections.sort(arr);
        
        for(int i = row_begin-1 ; i <row_end ; i++){
            int sum = 0;
            int[] row = arr.get(i).row;
            for(int j = 0; j< row.length; j++){
                sum += row[j]%(i+1);
            }
            res ^= sum;
        }
        
        return res;
    }
}