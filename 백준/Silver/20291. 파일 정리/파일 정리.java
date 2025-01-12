import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //pq, hm
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        PriorityQueue<String> q = new PriorityQueue<>();
        HashMap<String,Integer> hm =new HashMap<>();

        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String str = st.nextToken();

            if(hm.containsKey(str)){
                hm.replace(str,hm.get(str)+1);
            }
            else{
                hm.put(str,1);
                q.add(str);
            }

        }

        while(!q.isEmpty()){
            String str = q.poll();
            System.out.println(str+" "+hm.get(str));
        }

    }
}
