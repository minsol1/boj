import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        arr[3] = a*b;
        int idx =0;

        while(b!=0){
            int n = b%10;
            arr[idx++] = a*n;
            b /=10;
        }

        for(int i=0;i<4;i++){
            System.out.println(arr[i]);
        }

    }

}
