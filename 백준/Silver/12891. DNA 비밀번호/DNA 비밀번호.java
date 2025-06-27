import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,res;
    public static String str;
    public static int[] arr;
    public static int[] cnt;

    public static void add(char c){
        if(c == 'A'){
            cnt[0]++;
        }
        if(c == 'C'){
            cnt[1]++;
        }
        if(c == 'G'){
            cnt[2]++;
        }
        if(c == 'T'){
            cnt[3]++;
        }
    }
    public static void sub(char c){
        if(c == 'A'){
            cnt[0]--;
        }
        if(c == 'C'){
            cnt[1]--;
        }
        if(c == 'G'){
            cnt[2]--;
        }
        if(c == 'T'){
            cnt[3]--;
        }
    }

    public static void check(){
        for(int i =0;i<4;i++){
            if(cnt[i]<arr[i]) return;
        }
        res++;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        arr = new int[4];
        cnt = new int[4];

        str = br.readLine();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l =0;
        int r = M-1;

        for(int i =0;i<M;i++){
            char c = str.charAt(i);
            add(c);
        }
        check();

        while(r<N-1){
            sub(str.charAt(l));
            l++;
            r++;
            add(str.charAt(r));

            check();
        }

        System.out.println(res);

    }
}
