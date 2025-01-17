import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[11];
        int N = Integer.parseInt(br.readLine());
        int res =0;
        Arrays.fill(arr, -1);

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(arr[a]==-1){
                arr[a] = b;
            }
            else if(arr[a]!=b){
                res ++;
                arr[a] =b;
            }
        }

        System.out.println(res);
    }
}
