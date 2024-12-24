import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int res = 0;
        parent = new int[N+1];

        for(int i =0;i<N+1;i++){
            parent[i] = i;
        }

        for(int i =1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(check(s,e)){
                res=i;
                break;
            }
            else{
                union(s,e);
            }
        }

        System.out.print(res);
    }

    public static void union(int s,int e){
        int x = find(s);
        int y = find(e);

        if(x == y){
            return;
        }

        if(x<y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }

    }
    public static int find(int s){
        if(parent[s]==s){
            return s;
        }
        else return parent[s] = find(parent[s]);

    }
    public static boolean check(int s, int e){
        int x = find(s);
        int y = find(e);

        return x==y;
    }
}
