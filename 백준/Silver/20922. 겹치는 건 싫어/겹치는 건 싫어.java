import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] arr;
    public static int s,e;
    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res =0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        s=0;
        e=0;
        int[] cnt= new int[100001];
        while (e<N){
            while (e<N && cnt[arr[e]]+1<=M){
                cnt[arr[e]]++;
                e++;
            }
            if(res<e-s){
                res = e-s;
            }
            cnt[arr[s]]--;
            s++;

        }

        System.out.println(res);
    }
}
