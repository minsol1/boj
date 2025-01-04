import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t =0;t<T ;t++){
            int N = Integer.parseInt(br.readLine());
            int max =-1000000;
            int min = 1000000;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                int n = Integer.parseInt(st.nextToken());
                max = max>n ? max : n;
                min = min<n ? min : n;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
