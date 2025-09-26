import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = arr[0];
        int right = arr[1];

        for(int i = 2; i<N;i++){
            if(left == right) left+=arr[i];
            else if(left< right) left +=arr[i];
            else {
                right += arr[i];
            }
        }

        int m = Math.abs(left - right);
        int res = 0;
        int idx = 0;
        int[] chu = {100,50,20,10,5,2,1};
        while(m!=0){
            res += (m/chu[idx]);
            m %=chu[idx];
            idx++;
        }
        System.out.println(res);

    }
}
