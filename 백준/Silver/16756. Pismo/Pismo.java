
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N-1; i++){
            int n = Math.abs(arr[i]- arr[i+1]);
            min = min < n ? min : n;

        }
        System.out.println(min);
    }
}
