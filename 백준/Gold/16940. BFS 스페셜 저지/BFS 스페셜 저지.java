import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] arr;
    public static int N;
    public static boolean[] visited;
    public static int res=1;
    public static int[] ans;
    public static int idx =0;

    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        if(ans[idx++] != 1){
            res =0;
            return;
        }
        while (!q.isEmpty()){
            int now = q.poll();

            int cnt = 0;
            for(int i=0; i <arr[now].size() ; i++){
                int nx =arr[now].get(i);
                if(!visited[nx]){
                    visited[nx] = true;
                    cnt++;
                }
            }
            for(int i = idx ; i < idx +cnt ; i++){
                if(!visited[ans[i]]){
                    res = 0;
                    return;
                }else{
                    q.add(ans[i]);
                }
            }
            idx+=cnt;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr= new ArrayList[N+1];
        visited = new boolean[N+1];
        ans = new int[N];

        for(int i =0;i<N+1;i++){
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i =0;i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(res);
    }
}
