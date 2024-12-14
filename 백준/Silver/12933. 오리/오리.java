import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res=0, duck=0;
        int[] arr = new int[5];

        String str = br.readLine();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='q'){
                duck++;
                res = res>duck?res:duck;
                arr[0]++;
            }
            else if(c == 'u' && arr[0]>0){
                arr[0]--;
                arr[1]++;
            }
            else if(c == 'a'&& arr[1]>0){
                arr[1]--;
                arr[2]++;
            }
            else if(c == 'c'&& arr[2]>0){
                arr[2]--;
                arr[3]++;
            }
            else if(c == 'k'&& arr[3]>0){
                duck--;
                arr[3]--;
            }
            else{
                res = -1;
                break;
            }
        }

        for(int i =0;i<5;i++){
            if(arr[i]>0){
                res = -1;
                break;
            }
        }
        System.out.println(res);
    }
}
