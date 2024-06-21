import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static int N;
    public static int[] ans;
    public static int res =1;
    public static int idx =0;

    public static void dfs(int start ){
        visited[start] = true;
        HashSet<Integer> sh = new HashSet<>();
        for(int i =0;i< arr[start].size() ; i++){
            if(!visited[arr[start].get(i)]){
                sh.add(arr[start].get(i));
            }
        }

        if(sh.isEmpty()){
            return;
        }

        if(sh.contains(ans[idx])){
            dfs(ans[idx++]);
        }
        else{
            res = 0;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        ans = new int[N];
        for(int i =0;i<N+1;i++){
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i =0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        st = new StringTokenizer(br.readLine());

        for(int i =0;i<N;i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }

        if(ans[idx++] != 1){
            res =0;
        }else{
            dfs(1);
        }

        System.out.println(res);
    }
}
