
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] T;
    public static int N;
    public static String[] W;
    public static int[] C;
    public static int res;
    public static int[] cnt;

    public static void dfs(int idx, int total){
        if(idx == N){
            for(int i=0;i<26;i++){
                if(T[i]> cnt[i]){
                    return;
                }
            }
            res = res<total? res:total;
            return;
        }

        dfs(idx+1, total);

        for(int i=0;i< W[idx].length();i++){
            int c = W[idx].charAt(i)-'A';
            cnt[c]++;
        }
        dfs(idx+1,total+C[idx]);
        for(int i=0;i< W[idx].length();i++){
            int c = W[idx].charAt(i)-'A';
            cnt[c]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T=new int[26];
        cnt = new int[26];
        String text = br.readLine();
        for(int i=0;i<text.length();i++){
            int t = text.charAt(i)-'A';
            T[t] ++;
        }
        N = Integer.parseInt(br.readLine());
        C = new int[N];
        W = new String[N];
        res = 1600001;

        StringTokenizer st;

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            W[i] = st.nextToken();
        }

        dfs(0,0);

        if(res == 1600001){
            res =-1;
        }
        System.out.println(res);
    }
}
