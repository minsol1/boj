import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N*2];
        int cnt = 0;
        int res = 0;

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N*2;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robot = new boolean[N];
        int l =0;

        while(cnt<K){
            res++;
            l--;
            l = (l+N*2)%(N*2);
            for(int i = N-1; i>0 ; i--){
                robot[i] = robot[i-1];
            }
            robot[N-1] = false;
            robot[0] = false;

            for(int i = N-2; i>=0 ; i--){
                int next = (l+i+1) %(N*2);

                if(robot[i] && !robot[i+1] && arr[next]!=0){
                    arr[next]--;
                    if(arr[next]==0) cnt++;
                    robot[i] = false;
                    robot[i+1] = true;
                }
            }

            if(arr[l]!= 0){
                arr[l]--;
                if(arr[l]==0) cnt++;
                robot[0] = true;
            }

        }
        System.out.print(res);

    }
}
