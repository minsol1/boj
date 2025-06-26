import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if("empty".equals(str)){
                hs.clear();
                continue;
            }
            if("all".equals(str)){
                for(int j =1;j<21;j++){
                    hs.add(j);
                }
                continue;
            }

            int n = Integer.parseInt(st.nextToken());

            if("add".equals(str)){
                hs.add(n);
            }
            if("check".equals(str)){
                if(hs.contains(n)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            if("remove".equals(str)){
                hs.remove(n);
            }
            if("toggle".equals(str)){
                if(hs.contains(n)) hs.remove(n);
                else hs.add(n);
            }


        }
        System.out.println(sb);
    }
}
