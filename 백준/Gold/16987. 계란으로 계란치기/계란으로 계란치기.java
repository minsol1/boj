import java.io.*;
import java.util.*;

public class Main {
    public static int N,res;
    public static int[][] arr;

    public static void dfs(int idx, int cnt){
        if(idx >= N){
            res = cnt>res ? cnt:res;
            return;
        }

        if(arr[idx][0]<=0) {
            dfs(idx+1,cnt);
            return;
        }

        for(int i =0;i<N;i++){
            if(i == idx) continue;

            if(arr[i][0]>0){
                int c =0;
                arr[i][0]-=arr[idx][1];
                arr[idx][0]-=arr[i][1];

                if(arr[i][0]<=0) c++;
                if(arr[idx][0]<=0) c++;

                dfs(idx+1, cnt+c);

                arr[i][0]+=arr[idx][1];
                arr[idx][0]+=arr[i][1];

            }
            else dfs(idx+1,cnt);
        }

    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res = 0;
        arr=new int[N][2];

        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(res);

    }
}
