import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static char[] arr;
    public static char[] res;
    public static StringBuilder sb;

    public static void dfs(int idx, int cnt){
        if(cnt == N){
            int a =0;
            int b = 0;
            for(int i =0;i<N;i++){
                if(res[i] == 'a' ||res[i] == 'e' ||res[i] == 'i' ||res[i] == 'o' ||res[i] == 'u'){
                    a++;
                }else b++;
            }
            if(a>0 && b >1){
                for(char c : res) {
                    sb.append(c);
                }
                sb.append('\n');
            }

            return;
        }
        if(idx>= M){
            return;
        }
        res[cnt] = arr[idx];
        dfs(idx+1, cnt+1);
        dfs(idx+1, cnt);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M];
        res = new char[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<M;i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0,0);

        System.out.println(sb);
    }
}
