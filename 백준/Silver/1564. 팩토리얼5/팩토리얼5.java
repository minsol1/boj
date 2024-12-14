import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long res=1;
        long k = 1000000000000L;
        for(int i=1; i<=N ; i++){
            res *=i;
            while(res%10==0){
                res /=10;
            }
            res %=k;
        }

        res%=100000;

        String tem = String.format("%05d",res);
        System.out.println(tem);

    }
}
