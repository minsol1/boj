import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static boolean[] color;
    public static boolean[] visited;
    public static int[] people;
    public static ArrayList[] arr;
    public static int res;

    public static void dfs(int idx){
        if(idx > N){
            int rcnt=0;
            int bcnt =0;
            int rpeople =0;
            int bpeople = 0;

            for(int i =1; i<=N; i++){
                if(color[i]){
                    rcnt++;
                    rpeople+=people[i];
                }
                else{
                    bcnt++;
                    bpeople+=people[i];
                }
            }
            if(rcnt >0 && bcnt>0 && Math.abs(rpeople - bpeople)<res){

                visited = new boolean[N+1];
                for(int i =1 ;i <=N;i++){
                    if(color[i]){
                        bfs(i, color[i]);
                        break;
                    }
                }
                for(int i =1 ;i <=N;i++){
                    if(!color[i]){
                        bfs(i,color[i]);
                        break;
                    }
                }
                for(int i =1;i<=N ; i++){
                    if(!visited[i]) return;
                }

                res = Math.abs(rpeople - bpeople);

            }
            return;
        }

        dfs(idx+1);
        color[idx] = true;
        dfs(idx+1);
        color[idx] = false;

    }

    public static void bfs(int start, boolean f){
       Queue<Integer> q = new ArrayDeque<>();
       q.add(start);
       visited[start] = true;

       while(!q.isEmpty()){
           int n = q.poll();

           for(int i =0;i<arr[n].size();i++){
               int nx = (int)arr[n].get(i);
               if(!visited[nx] && f == color[nx]){
                   visited[nx] = true;
                   q.add(nx);
               }
           }
       }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new boolean[N+1];
        arr = new ArrayList[N+1];
        people = new int[N+1];
        res = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1;i<=N;i++){
            people[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            for(int j =0; j<t; j++){
                int c = Integer.parseInt(st.nextToken());
                if(c != 0){
                    arr[i].add(c);
                    arr[c].add(i);
                }
            }
        }

        dfs(1);

        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else System.out.println(res);
    }
}
