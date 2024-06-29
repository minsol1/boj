import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int C;
    public static long dfs(long a, long b){
        if(b == 1){
            return a%C;
        }
        long temp = dfs(a, b/2);
        if(b%2 ==1){
            return (temp * temp)%C * a%C;
        }
        else{
            return (temp * temp)%C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long res=1;

//        for(int i = 0; i< B%C ; i++){
//            res = ((res%C) * (A%C))%C;
//        }

        res = dfs(A, B)%C;

        System.out.println(res);

    }
}
