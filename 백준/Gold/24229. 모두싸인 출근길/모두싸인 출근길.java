
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) ->{
            return  a[0]!= b[0] ? a[0]- b[0] : a[1] - b[1];
        });
        int start = 0;
        int end = 0;
        int res = 0;
        int jump = 0;

        for(int i =0; i<N; i++){
            if(arr[i][0] <= end){ // 걸어서 이동 가능
                end = Math.max(end, arr[i][1]);
                jump = Math.max( end + end - start, jump);
                res = Math.max (arr[i][1], res);
                continue;
            }
            if(arr[i][0] <= jump){ // 점프 가능
                start = arr[i][0];
                end = Math.max(end, arr[i][1]);
                jump = Math.max( end + end - start, jump);
                res = Math.max (arr[i][1], res);
            }
        }

        System.out.println(res);

    }
}
