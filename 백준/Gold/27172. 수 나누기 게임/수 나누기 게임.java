import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max=0;
        for(int i =1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = max> arr[i]?max:arr[i];
        }
        int[] pos = new int[max+1];

        for(int i = 1; i<N+1;i++){
            pos[arr[i]] = i;
        }

        for(int i =1;i<N+1;i++){
            int n = arr[i];

            for(int j= n*2; j<=max ; j+=n){
                if(pos[j]!=0){
                    res[pos[j]-1] --;
                    res[pos[n]-1] ++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : res){
            sb.append(n).append(" ");
        }

        System.out.print(sb);

    }
}
