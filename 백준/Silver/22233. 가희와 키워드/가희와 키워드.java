import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        for(int i =0;i<N;i++){
            String str = br.readLine();
            hs.add(str);
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine(),",");

            while(st.hasMoreTokens()){
                hs.remove(st.nextToken());
            }

            sb.append(hs.size()).append('\n');

        }
        System.out.println(sb);
    }
}
