import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> res = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N ; i>0 ; i--){
            res.add(arr[i-1],i);
        }

        for(int i : res){
            System.out.print(i+" ");
        }

    }
}
