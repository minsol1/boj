import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int total = 0;

        for(int i =0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            total+= arr[i];
        }
        Arrays.sort(arr);
        int a=0;
        int b=1;

        for(int i =0;i<8;i++){
            for(int j = i+1;j<9;j++){
                if(total-arr[i]-arr[j]==100){
                    a=i;
                    b=j;
                }
            }
        }

        for(int i =0;i<9;i++){
            if(i == a || i==b) continue;
            System.out.println(arr[i]);
        }
    }
}
