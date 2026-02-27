
import java.io.*;
import java.util.*;


public class Main {

    public static int N, M;
    public static HashMap<String, Integer>[] time;
    public static HashMap<String, Integer>[] cnt;
    public static HashSet<String> set;

    public static int getTime(String start, String end){
        int total = 0;
        StringTokenizer st = new StringTokenizer(start, ":");
        int Shour = Integer.parseInt(st.nextToken());
        int Smin = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(end, ":");
        int Ehour = Integer.parseInt(st.nextToken());
        int Emin = Integer.parseInt(st.nextToken());

//        System.out.println(Shour+" "+ Smin +" "+ Ehour+" "+ Emin);

        total = (Ehour*60 + Emin) - (Shour*60 + Smin);
//        System.out.println(total);
        return total;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int W = M/7;
        time = new HashMap[W];
        cnt = new HashMap[W];
        set = new HashSet<>();

        for(int i =0; i < W ; i++){
            time[i] = new HashMap<>();
            cnt[i] = new HashMap<>();
        }

        for(int i = 0; i< N ; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken())-1;
            int week = day/7;
            String start = st.nextToken();
            String end = st.nextToken();

            int t = getTime(start, end);

            time[week].put(name, time[week].getOrDefault(name,0)+t );
            cnt[week].put(name, cnt[week].getOrDefault(name,0)+1 );
            set.add(name);
        }

        ArrayList<String> res = new ArrayList<>();
        for(String name : set){
            int c = 0;
            for(int i =0; i< W ; i++){
                if(!time[i].containsKey(name) ||!cnt[i].containsKey(name)) break;
                if(time[i].get(name) >=60*60 && cnt[i].get(name)>=5) c++;
            }
//            System.out.println(name+" "+ c +" "+W);

            if(c == W){
                res.add(name);
            }
        }

        if(res.isEmpty()){
            System.out.println(-1);
        }
        else{
            Collections.sort(res);
            for(String name : res){
                System.out.println(name);
            }
        }
    }
}
