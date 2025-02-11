import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for(int c = 0;c<C;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int sum =0;
            int cnt=0;

            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            for(int i =0;i<N;i++){
                if(arr[i] > (sum/N)){
                    cnt++;
                }
            }
            System.out.println(((float)cnt/(float)N)*100+"%");
        }
    }

}
