
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res = 0;

        String str = br.readLine();
        for(int i =0; i< N ; i++){
            int c = str.charAt(i)-'0';
            if(c == 1) res ++;
        }

        System.out.println(res);
    }
}
