import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = max > arr[i]? max : arr[i];
        }
        float res =0;
        for(int i =0;i<N;i++){
            res += ((float)arr[i]/max*100);
        }
        System.out.print(res/N);

    }

}
