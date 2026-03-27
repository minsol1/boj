
import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int N;

    public static boolean check(int s, int e){
        if(s>=e) return true;

        if(arr[s] != arr[e]){
            return false;
        }
        else return check(s+1, e-1);

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=  new int[N];
        int res = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        boolean f= false;
        int c = 1;

        while(i+c < N){

            if(!check(i,i+c)){
                c+=2;
                f = false;
            }
            else{
                i += (c+1);
                res ++;
                f = true;
                c = 1;
            }

        }

        if(f)
            System.out.println(res);
        else System.out.println(-1);

    }
}
