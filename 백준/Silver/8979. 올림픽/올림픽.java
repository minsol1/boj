import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr =new int[N+1][3];
        int res =1;

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
            arr[n][2] = Integer.parseInt(st.nextToken());
        }

        for(int i =1;i<N+1;i++){
            if(i == M) continue;
            if(arr[i][0]> arr[M][0]){
                res++;
            }
            else if(arr[i][0]== arr[M][0] && arr[i][1]>arr[M][1]){
                res++;
            }
            else if(arr[i][0]== arr[M][0] && arr[i][1]==arr[M][1]&& arr[i][2]>arr[M][2]){
                res++;
            }

        }
        System.out.print(res);

    }
}
