
import java.io.*;
import java.util.*;

public class Main {

    public static long gcb(long a, long b){
        if(b == 0 )return a;
        return gcb(b, a%b);
    }

    public static long lcm(long a, long b){
        return a*b / gcb(a,b);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1; i< N+1 ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> t = new ArrayList<>();
        for(int i =1; i< N+1; i++){
            int s = arr[i];
            long c = 0;

            while(true){
                c++;
                s = arr[s];
                if(s == arr[i]){
                    break;
                }
            }
            t.add(c);

        }
        Collections.sort(t);
        Collections.reverse(t);

        long res  = t.get(0);
        for(int i = 0 ; i< N ; i++){
            res = lcm(res, t.get(i));
        }

        System.out.println(res);

    }
}
