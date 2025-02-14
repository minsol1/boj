import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];
        int cnt0 =0;
        int cnt1 =0;

        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i)-'0';
            if(arr[i]==0){
                cnt0++;
            }
            else cnt1++;
        }

        int cnt =0;
        for(int i =0;i<str.length();i++){
            if(arr[i]==1){
                arr[i]=2;
                cnt++;
            }
            if (cnt == cnt1/2) break;
        }

        cnt =0;
        for(int i =str.length()-1;i>=0;i--){
            if(arr[i]==0){
                arr[i]=2;
                cnt++;
            }
            if (cnt == cnt0/2) break;
        }

        for(int i :arr){
            if(i!=2) System.out.print(i);
        }
    }
}
