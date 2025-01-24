import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int[] res = new int[P+1];
        for(int p =1 ; p<=P;p++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[20];
            st.nextToken();
            for(int i=0;i<20;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =0;i<20;i++){
                for(int j =0;j<i;j++){
                    if(arr[i]<arr[j]) res[p]++;
                }
            }
        }

        for(int i =1;i<=P;i++){
            System.out.println(i+" "+ res[i]);
        }
    }
}
