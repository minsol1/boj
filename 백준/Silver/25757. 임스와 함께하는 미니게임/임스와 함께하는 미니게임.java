import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String M = st.nextToken();
        HashSet<String> hs = new HashSet<>();

        for(int i =0;i<N;i++){
            String str =br.readLine();
            hs.add(str);
        }

        int res = 0;
        if(M.equals("Y")){
            res = hs.size();
        }
        else if(M.equals("F")){
            res = hs.size()/2;
        }
        else if(M.equals("O")){
            res = hs.size()/3;
        }

        System.out.println(res);
    }
}
