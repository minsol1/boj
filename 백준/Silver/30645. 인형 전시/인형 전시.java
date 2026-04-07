
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[C];
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i< M ; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int i =0;

        while(!pq.isEmpty()){
            int n = pq.poll();
            if(n == arr[i%C] ) continue;

            arr[i%C] = n;
            res++;
            i++;
            
            if(res >= R*C) break;
        }
        System.out.println(res);
    }
}
