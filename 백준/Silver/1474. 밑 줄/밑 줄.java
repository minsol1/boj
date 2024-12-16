import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        int len=0;
        for(int i =0;i<N;i++){
            arr[i] = br.readLine();
            len+= arr[i].length();
        }
        StringBuilder sb= new StringBuilder();
        for(int i =0;i< (M-len)/(N-1);i++){
            sb.append('_');
        }
        for(int i =0;i<N-1;i++){
            arr[i]= arr[i]+sb;
        }

        int cnt = (M-len)%(N-1);
        int idx =1;
        while(cnt>0 && idx<N){
            if(arr[idx].charAt(0)>='a' && arr[idx].charAt(0)<='z'){
                arr[idx] = '_'+arr[idx];
                cnt--;
            }
            idx++;
        }
        idx = N-1;
        while(cnt>0&& idx>0){
            if(arr[idx].charAt(0)>='A' && arr[idx].charAt(0)<='Z'){
                arr[idx] = '_'+arr[idx];
                cnt--;
            }
            idx--;
        }

        for(int i =0;i<N;i++){
            System.out.print(arr[i]);
        }

    }
}
