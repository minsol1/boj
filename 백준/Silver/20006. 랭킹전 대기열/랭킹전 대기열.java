import java.io.*;
import java.util.*;

class Team{
    int level;
    ArrayList<String> p;
    boolean f;

    public Team(int l){
        level = l;
        p = new ArrayList<>();
        f = false;
    }

}


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Team> arr = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean f = false;

            hm.put(name,l);

            for(Team t : arr){
                if(Math.abs(t.level-l)<=10 && !t.f){
                    t.p.add(name);
                    if(t.p.size()>=M) t.f = true;
                    f = true;
                    break;
                }
            }
            if(!f){
                Team t = new Team(l);
                t.p.add(name);
                if(t.p.size()>=M) t.f = true;
                arr.add(t);
            }
        }

        for(Team t : arr){
            if(t.f){
                System.out.println("Started!");
            }
            else {
                System.out.println("Waiting!");
            }
            Collections.sort(t.p);
            for(String n : t.p){
                System.out.println(hm.get(n)+" "+ n);
            }
        }

    }
}
